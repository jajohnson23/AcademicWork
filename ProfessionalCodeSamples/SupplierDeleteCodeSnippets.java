//Code Samples - Snippets of patches from my tickets
//Back-end samples
	incrementTotalRecords();
 
 						sheetHasProcessedData = true;
-						if (hasSupplierId && hasSupplierNumber) {
+						if (hasSupplierId && isDeletedSupplier(supplierIdCell, connection)) {
+							addImportErrorMessage(row, supplierIdCell, SupplierGroupExportImportFields.SUPPLIER_ID_MATCHES_DELETED_SUPPLIER);
+						}
+						else if (!hasSupplierId && hasSupplierNumber && isDeletedSupplierByNumber (supplierNumberCell, connection)) {
+							addImportErrorMessage(row, supplierNumberCell, SupplierGroupExportImportFields.SUPPLIER_NUMBER_MATCHES_DELETED_SUPPLIER);
+						}
+						else if (hasSupplierId && hasSupplierNumber) {
 							importSupplierOnSupplierIdAndSupplierName(row, supplierIdCell, supplierNumberCell, connection);
 						}
 						else if (hasSupplierId) {
@@ -343,4 +352,34 @@
 		this.supplierIdsToAdd.clear();
 		super.resetImporterForNextSheet();
 	}
+
+	private boolean isDeletedSupplier (Cell supplierIdCell, Connection connection) throws SQLException, ExcelParseException{
+		GSPSupplier supplier;
+		try {
+			supplier = loadSupplierById(supplierIdCell, connection);
+		} catch (Exception e) {
+			return false;
+
+		}
+		Collection<String> deletedSupplierIds = SupplierPipelinedSearch.getSuppliersDeletedByCustomerFromIndex(user.getOrgID(), connection);
+		for (String supplierID : deletedSupplierIds) {
+			if (supplier != null && NumberUtils.safeEquals(Long.valueOf(supplierID), Long.valueOf(supplier.getId()))){
+				return true;
+			}
+		}
+		return false;
+	}
+	private boolean isDeletedSupplierByNumber (Cell supplierNumberCell, Connection connection) throws SQLException, ExcelParseException{
+		CustomerRelationship relationship = loadRelationshipByInternalVendorNumber(supplierNumberCell, connection);
+		Collection<String> deletedSupplierIds = SupplierPipelinedSearch.getSuppliersDeletedByCustomerFromIndex(user.getOrgID(), connection);
+		if (relationship !=null) {
+			for (String supplierID : deletedSupplierIds) {
+				if (NumberUtils.safeEquals(Long.valueOf(supplierID), Long.valueOf(relationship.getSupplierId()))) {
+					return true;
+				}
+			}
+		}
+		return false;
+	}
+
 }
 //another file snippet
 +	//added for use in applying Deleted Supplier Styling
+	protected SupplierVisibilityTypeEnum supplierVisibilityType;
+	protected boolean isDeletedSupplier;
+
 	//DEVNOTE: This could potentially be "out of date" information since the getter on the profile requires a connection, but
 	//some of the call sites for this value for a legal entity do not have a connection object available, we'll set this member
 	//at construction time...jjohns 2/26/2015
@@ -607,4 +613,35 @@
 		return dislayForEachLinkedType;
 	}
 
+	protected boolean isSupplierActive() {
+		return supplier.isActive(relationship.getCustomerOrg());
+	}
+
+	public boolean isSupplierVisibleToCustomer() {
+		if (supplierVisibilityType == null) {
+			return true;
+		}
+
+		return supplierVisibilityType.isSupplierVisibleToCustomer();
+	}
+
+	/*
+	 * determines status for applying phoenix styling for deleted (or not) suppliers
+	 */
+	@Override
+	public PhoenixStatusEnum getPhoenixStatus() {
+		PhoenixStatusEnum status = PhoenixStatusEnum.INACTIVE;
+
+		if (isSupplierActive()) {
+			status = PhoenixStatusEnum.ACTIVE;
+		}
+
+		if (!isSupplierVisibleToCustomer()) {
+			status = PhoenixStatusEnum.DELETED;
+		}
+
+		return status;
+	}
+
 }
 
 ///another patch, includes java and jsp files needed for the ticket	
 public boolean isSupplierManagementSearch (GenericSupplierSearchDisplayBean supplierSearchDisplayBean) {
+		SupplierSearchPageContext context = supplierSearchDisplayBean.getSearchInputHandler().getSearchPageContext();
+		return context.equals(SupplierSearchPageContext.SUPPLIERMANGEMENTSEARCH);
+	}
+
 }

@@ -266,7 +266,8 @@
 				
 				<html:simpleFormRow
 					fieldName="<%= SupplierSearchQueryParameter.SUPPLIER_SHOW_DELETED_SUPPLIERS_ONLY.getFieldName()  %>"
-					hidden="<%=!SupplierSearchQueryParameter.SUPPLIER_SHOW_DELETED_SUPPLIERS_ONLY.isVisible(supplierSearchDisplayBean.getUser()) %>"
+					hidden="<%=!SupplierSearchQueryParameter.SUPPLIER_SHOW_DELETED_SUPPLIERS_ONLY.isVisible(supplierSearchDisplayBean.getUser())
+					          || !SupplierSearchQueryParameter.SUPPLIER_SHOW_DELETED_SUPPLIERS_ONLY.isSupplierManagementSearch(supplierSearchDisplayBean)%>"
 					labelId="<%= SupplierSearchQueryParameter.SUPPLIER_SHOW_DELETED_SUPPLIERS_ONLY.getInternalName() + SupplierSearchCommand.LABEL %>">
 					<html:checkBox
 						fieldName="<%= SupplierSearchQueryParameter.SUPPLIER_SHOW_DELETED_SUPPLIERS_ONLY.getFieldName()%>"

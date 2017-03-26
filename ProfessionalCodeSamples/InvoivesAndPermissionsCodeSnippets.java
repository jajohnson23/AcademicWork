//Code Snippets from Work on Invoices and User Permissions
//This is from a ticket to update CSV import of a User
 	public static final Field USEREXPORTHEADER_ROLEPURCHASEORDERAPPROVALLIMIT =
-		new Field("UserExportHeader_RolePurchaseOrderApprovalLimit", "RolePurchase Order Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_7_2, ReleaseTeams.TEAM_PRIOR_TO_15_3)
+		new Field("UserExportHeader_RolePurchaseOrderApprovalLimit", "Role " + Thesaurus.PurchaseOrder + " Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_7_2, ReleaseTeams.TEAM_PRIOR_TO_15_3)
 		.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
 	public static final Field USEREXPORTHEADER_PURCHASEORDERAPPROVALLIMIT =
 		new Field("UserExportHeader_PurchaseOrderApprovalLimit", Thesaurus.PurchaseOrder + " Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_7_2, ReleaseTeams.TEAM_PRIOR_TO_15_3)
@@ -681,6 +681,45 @@
 	public static final Field USEREXPORTHEADER_LILIMITEDPOLIMIT =
 		new Field("UserExportHeader_LILimitedPOLimit", "Line Item Limited " + Thesaurus.PurchaseOrder + " Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_7_2, ReleaseTeams.TEAM_PRIOR_TO_15_3)
 		.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+	//Invoice Limit Headers
+	public static final Field USEREXPORTHEADER_USERINVOICELIMIT =
+			new Field("UserExportHeader_UserInvoiceLimit", "User " + Thesaurus.Invoice + " Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_ROLEINVOICELIMIT =
+			new Field("UserExportHeader_RoleInvoiceLimit", "Role " + Thesaurus.Invoice + " Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_INVOICELIMIT =
+			new Field("UserExportHeader_InvoiceLimit", Thesaurus.Invoice + " Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_USERINVOICELILIMIT =
+			new Field("UserExportHeader_UserInvoiceLILimit", "User " + Thesaurus.Invoice + " Line Item Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_ROLEINVOICELILIMIT =
+			new Field("UserExportHeader_RoleInvoiceLILimit", "Role " + Thesaurus.Invoice + " Line Item Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_INVOICELILIMIT =
+			new Field("UserExportHeader_InvoiceLILimit", Thesaurus.Invoice + " Line Item Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_USERINVOICEAPPROVALLIMIT =
+			new Field("UserExportHeader_UserInvoiceApprovalLimit", "User " + Thesaurus.Invoice + " Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_ROLEINVOICEAPPROVALLIMIT =
+			new Field("UserExportHeader_RoleInvoiceApprovalLimit", "Role " + Thesaurus.invoice + " Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_INVOICEAPPROVALLIMIT =
+			new Field("UserExportHeader_InvoiceApprovalLimit", Thesaurus.Invoice + " Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_USERINVOICELIAPPROVALLIMIT =
+			new Field("UserExportHeader_UserInvoiceLIApprovalLimit", "User " + Thesaurus.Invoice + " Line Item Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_ROLEINVOICELIAPPROVALLIMIT =
+			new Field("UserExportHeader_RoleInvoiceLIApprovalLimit", "Role " + Thesaurus.Invoice + " Line Item Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+		public static final Field USEREXPORTHEADER_INVOICELIAPPROVALLIMIT =
+			new Field("UserExportHeader_InvoiceLIApprovalLimit", Thesaurus.Invoice+ " Line Item Approval Limit", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS)
+			.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
+
+
 	public static final Field USEREXPORTHEADER_CREDITCARDS =
 		new Field("UserExportHeader_CreditCards", "Credit Cards", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_7_2, ReleaseTeams.TEAM_PRIOR_TO_15_3)
 		.setRequiredSetting(RequiredSetting.DEFAULT_NOT_REQUIRED);
@@ -1425,6 +1464,18 @@
 				USEREXPORTHEADER_USERLILIMITEDPOLIMIT,
 				USEREXPORTHEADER_ROLELILIMITEDPOLIMIT,
 				USEREXPORTHEADER_LILIMITEDPOLIMIT,
+				USEREXPORTHEADER_USERINVOICELIMIT,
+				USEREXPORTHEADER_ROLEINVOICELIMIT,
+				USEREXPORTHEADER_INVOICELIMIT,
+				USEREXPORTHEADER_USERINVOICELILIMIT,
+				USEREXPORTHEADER_ROLEINVOICELILIMIT,
+				USEREXPORTHEADER_INVOICELILIMIT,
+				USEREXPORTHEADER_USERINVOICEAPPROVALLIMIT,
+				USEREXPORTHEADER_ROLEINVOICEAPPROVALLIMIT,
+				USEREXPORTHEADER_INVOICEAPPROVALLIMIT,
+				USEREXPORTHEADER_USERINVOICELIAPPROVALLIMIT,
+				USEREXPORTHEADER_ROLEINVOICELIAPPROVALLIMIT,
+				USEREXPORTHEADER_INVOICELIAPPROVALLIMIT,
 				USEREXPORTHEADER_CREDITCARDS,
 				USEREXPORTHEADER_NUMBEROFCREDITCARDS,
 				USEREXPORTHEADER_APPLYDEFAULTCARD,
I
         addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_ROLELILIMITEDPOLIMIT.getInternalName());
         addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_LILIMITEDPOLIMIT.getInternalName());
 
+        // Invoice Limit
+		addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_USERINVOICELIMIT.getInternalName());
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_ROLEINVOICELIMIT.getInternalName());
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_INVOICELIMIT.getInternalName());
+
+        // Invoice Line Limit
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_USERINVOICELILIMIT.getInternalName());
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_ROLEINVOICELILIMIT.getInternalName());
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_INVOICELILIMIT.getInternalName());
+
+        // Invoice approval limit
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_USERINVOICEAPPROVALLIMIT.getInternalName());
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_ROLEINVOICEAPPROVALLIMIT.getInternalName());
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_INVOICEAPPROVALLIMIT.getInternalName());
+
+        // Invoice line item approval limit
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_USERINVOICELIAPPROVALLIMIT.getInternalName());
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_ROLEINVOICELIAPPROVALLIMIT.getInternalName());
+        addToExportHeaderList(Section_UserSearch_Fields.USEREXPORTHEADER_INVOICELIAPPROVALLIMIT.getInternalName());
+
 	}
 
 	/**
I
             exportValueIfHeaderIsVisible(Section_UserSearch_Fields.USEREXPORTHEADER_DEFAULTFINANCIALAPPROVER.getInternalName(), getUserNameById(NoGarbageUtils.getLong(approverId), connection));
             exportValueIfHeaderIsVisible(Section_UserSearch_Fields.USEREXPORTHEADER_FINANCIALAPPROVERS.getInternalName(), getFinancialApprovers(appUser, connection));
 
-    		// Purchasing / Approval Limits
+    		// Purchasing and Invoice/ Approval Limits
             buildPurchasingHeaderVisibility();
             exportPurchaseLimits(appUser);
 
@@ -646,6 +646,10 @@
         writePurchaseLimits(user, AppUser.ATTR_LIMIT_APPROVAL_POLINEITEM);
         writePurchaseLimits(user, AppUser.ATTR_LIMIT_LPO_REQTOTAL);
         writePurchaseLimits(user, AppUser.ATTR_LIMIT_LPO_REQLINE);
+        writePurchaseLimits(user, AppUser.ATTR_LIMIT_INVOICELIMIT);
+		writePurchaseLimits(user, AppUser.ATTR_LIMIT_INVOICELINEITEM_LIMIT);
+        writePurchaseLimits(user, AppUser.ATTR_LIMIT_APPROVAL_INVOICELIMIT);
+        writePurchaseLimits(user, AppUser.ATTR_LIMIT_APPROVAL_INVOICELINEITEMLIMIT);
 	}
 
     private String getAddressAsString(AppUser user, UserAddress userAddress) {
@@ -1192,5 +1196,26 @@
                         Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_USERLILIMITEDPOLIMIT.getInternalName())),
                         Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_ROLELILIMITEDPOLIMIT.getInternalName())),
                         Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_LILIMITEDPOLIMIT.getInternalName()))));
+        purchasingHeaderVisibilityMap.put(AppUser.ATTR_LIMIT_INVOICELIMIT,
+                Arrays.asList(
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_USERINVOICELIMIT.getInternalName())),
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_ROLEINVOICELIMIT.getInternalName())),
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_INVOICELIMIT.getInternalName()))));
+        purchasingHeaderVisibilityMap.put(AppUser.ATTR_LIMIT_INVOICELINEITEM_LIMIT,
+                Arrays.asList(
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_USERINVOICELILIMIT.getInternalName())),
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_ROLEINVOICELILIMIT.getInternalName())),
+                        Boolean.valueOf( headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_INVOICELILIMIT.getInternalName()))));
+        purchasingHeaderVisibilityMap.put(AppUser.ATTR_LIMIT_APPROVAL_INVOICELIMIT,
+                Arrays.asList(
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_USERINVOICEAPPROVALLIMIT.getInternalName())),
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_ROLEINVOICEAPPROVALLIMIT.getInternalName())),
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_INVOICEAPPROVALLIMIT.getInternalName()))));
+        purchasingHeaderVisibilityMap.put(AppUser.ATTR_LIMIT_APPROVAL_INVOICELINEITEMLIMIT,
+                Arrays.asList(
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_USERINVOICELIAPPROVALLIMIT.getInternalName())),
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_ROLEINVOICELIAPPROVALLIMIT.getInternalName())),
+                        Boolean.valueOf(headerList.contains(Section_UserSearch_Fields.USEREXPORTHEADER_INVOICELIAPPROVALLIMIT.getInternalName()))));
+
     }
 }
 
 
 
//This also related to an update for users and Permissions including updating the UI to display the permissions with checks if they had the permission and X if they do not
 	public static final Field WFFINAPPROVERS_PREFERREDAPPROVER =
 		new Field("WfFinApproversPreferredApprover", "Preferred Approver", VisibleSetting.ALWAYS_VISIBLE, ReleaseNumbers.R_11_3, ReleaseTeams.TEAM_PRIOR_TO_15_3);
+	public static final Field HEADER_WFFINAPPROVERS_REQUISITIONAPPROVER =
+		new Field("WfFinApproversRequisitionApprover", Thesaurus.Requisitions, VisibleSetting.ALWAYS_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS);
+	public static final Field HEADER_WFFINAPPROVERS_POAPPROVER =
+		new Field("WfFinApproversPOApprover", Thesaurus.PurchaseOrders, VisibleSetting.ALWAYS_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS);
+	public static final Field HEADER_WFFINAPPROVERS_INVOICEAPPROVER =
+		new Field("WfFinApproversInvoiceApprover", Thesaurus.Invoices, VisibleSetting.ALWAYS_VISIBLE, ReleaseNumbers.R_16_2, ReleaseTeams.CHRONOS);
 	public static final Field HEADER_WFFINAPPROVERSACTION =
 		new Field("Header_WfFinApproversAction", "Action", VisibleSetting.DEFAULT_VISIBLE, ReleaseNumbers.R_11_3, ReleaseTeams.TEAM_PRIOR_TO_15_3);
 	public static final Field WFFINAPPROVERSSETPREFERRED =
@@ -82,6 +88,9 @@
 			BUTTON_WFFINAPPROVERSADDAPPROVERS,
 			HEADER_WFFINAPPROVERSNAME,
 			WFFINAPPROVERS_PREFERREDAPPROVER,
+			HEADER_WFFINAPPROVERS_REQUISITIONAPPROVER,
+			HEADER_WFFINAPPROVERS_POAPPROVER,
+			HEADER_WFFINAPPROVERS_INVOICEAPPROVER,
 			HEADER_WFFINAPPROVERSACTION,
 			WFFINAPPROVERSSETPREFERRED,
 			WFFINAPPROVERSSETPREFERREDTITLETEXT,

diff -u -r1.21 WfFinancialApproversSection.java
 	/** Action for Setting Preferred Financial approver */
 	public static final String ACTION_PREFERED = "Preferred";
-	
+
 	/** Action for Removing the Preferred Financial approver */
 	public static final String ACTION_REMOVEPREFERED = "RemovePrefered";
 
@@ -233,7 +235,7 @@
 						Section_WfFinApprovers_Fields.ERR_WFFINAPPROVERSAPPROVERNOTFOUND.getInternalName(),
 						null);
 				}
-				
+
 				BubbleNotification.createSuccessNotification(fieldMaster).setMessage(Section_WfFinApprovers_Fields.WFFINAPPROVERS_APPROVER_REMOVED).addToSession(session);
 			}//Action - Preferred
 			else if(action.equals(ACTION_PREFERED)) {
@@ -247,12 +249,12 @@
 						AuditTrailActionOrigin.UI,
 						connection,
 						keyManager);
-				
+
 				BubbleNotification.createSuccessNotification(fieldMaster).setMessage(Section_WfFinApprovers_Fields.WFFINAPPROVERS_APPROVER_UPDATED).addToSession(session);
 			} else if(action.equals(ACTION_REMOVEPREFERED)) {
-				
+
 				administeredUser.savePreferredFinancialApprover(null, connection);
-				
+
 				//save audit records
 				administeredUser.getAuditTrailManager().savePendingRecords(
 						user,
@@ -260,7 +262,7 @@
 						AuditTrailActionOrigin.UI,
 						connection,
 						keyManager);
-				
+
 				BubbleNotification.createSuccessNotification(fieldMaster).setMessage(Section_WfFinApprovers_Fields.WFFINAPPROVERS_APPROVER_UPDATED).addToSession(session);
 			}
 			//Action - AddApprover
@@ -277,7 +279,7 @@
 							AuditTrailActionOrigin.UI,
 							connection,
 							keyManager);
-				
+
 					BubbleNotification.createSuccessNotification(fieldMaster).setMessage(Section_WfFinApprovers_Fields.WFFINAPPROVERS_APPROVER_UPDATED).addToSession(session);
 				} else {
 					errorManager.addError(
@@ -382,4 +384,47 @@
 		financialApproversUsers = collection;
 	}
 
+	public boolean isReqApproverColumnVisible() {
+		if (user.getOrg().hasLicenseModule(LicenseModules.REQUISITION_MANAGER)) {
+			return false;
+		}
+		return true;
+	}
+
+	public boolean isPOApproverColumnVisible() {
+		Organization org = user.getOrg();
+		if (org.hasLicenseModule(LicenseModules.ORDER_MANAGER)) {
+			return false;
+		}
+		return true;
+	}
+
+	public boolean isInvoiceApproverColumnVisible() {
+		if (user.getOrg().hasLicenseModule(LicenseModules.INVOICE_MANAGER)) {
+			return false;
+		}
+		return true;
+	}
+
+	public boolean hasReqApprovalPermission (User user) {
+			if (user.hasAnyPermission(PermissionFields.PERM_APPROVEREJECTWORKFLOWREQS)) {
+				return true;
+			}
+		return false;
+	}
+
+	public boolean hasPOApprovalPermission (User user) {
+		if (user.hasAnyPermission(PermissionFields.PERM_APPROVEREJECTWORKFLOWPO)) {
+			return true;
+		}
+	return false;
+	}
+
+	public boolean hasInvoiceApprovalPermission (User user) {
+		if (user.hasAnyPermission(PermissionFields.PERM_APPROVEWORKFLOWINVOICES)) {
+			return true;
+		}
+	return false;
+	}
+
 }

diff -u -r1.26 wfFinancialApproversSection.include

 
 <%
 	WfFinancialApproversSection wfFinancialApproversSection = (WfFinancialApproversSection) displayBean.getSection();
@@ -40,10 +47,17 @@
 						fieldName="<%= Section_WfFinApprovers_Fields.WFFINAPPROVERS_LISTLABEL.getInternalName() %>"
 						width="<%= displayBean.getDisplayContext().isPhoenixUI() ? UserProfileCommand.DEFAULT_RIGHT_PANEL_WIDTH : "100%" %>">
 					
-						<html:resultsTableLayout>
+						<html:phoenixResultsTableLayout results="<%=wfFinancialApproversSection.getFinancialApproversUsers() %>">
+							
 							<html:resultsTableHeaderRow>
-								<html:resultsTableColumnHeader fieldName="<%=Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERSNAME.getInternalName()%>" nowrap="true" />
-								<html:resultsTableColumnHeader fieldName="<%=Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERSACTION.getInternalName()%>" hidden="<%=readOnly%>" nowrap="true" valueAlignment="right" width="1%" />
+								<html:resultsTableColumnHeader fieldName="<%=Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERSNAME.getInternalName()%>" nowrap="true" noWrapHeader="true"  />
+								<html:resultsTableColumnHeader fieldName="<%= StringUtils.BLANK_STRING %>" valueAlignment="center" />
+								<html:resultsTableColumnHeader fieldName="<%=Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_REQUISITIONAPPROVER.getInternalName()%>" nowrap="true" noWrapHeader="true" valueAlignment="center" hidden="<%=wfFinancialApproversSection.isReqApproverColumnVisible()%>" />
+								<html:resultsTableColumnHeader fieldName="<%=Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_POAPPROVER.getInternalName()%>" nowrap="true" noWrapHeader="true" valueAlignment="center" hidden="<%=wfFinancialApproversSection.isPOApproverColumnVisible()%>"/>
+								<html:resultsTableColumnHeader fieldName="<%=Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_INVOICEAPPROVER.getInternalName()%>" nowrap="true" noWrapHeader="true" valueAlignment="center" hidden="<%=wfFinancialApproversSection.isInvoiceApproverColumnVisible()%>"/>
+								<html:resultsTableColumnHeader fieldName="<%= StringUtils.BLANK_STRING %>" valueAlignment="center" />						
+								<html:resultsTableColumnHeader fieldName="<%=Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERSACTION.getInternalName()%>" hidden="<%=readOnly%>" nowrap="true" noWrapHeader="true" valueAlignment="right" width="1%" />
+								<html:resultsTableColumnHeader fieldName="<%= StringUtils.BLANK_STRING %>" valueAlignment="center" />
 							</html:resultsTableHeaderRow>               
 <%
 							String preferedFinancialApprover = wfFinancialApproversSection.getPreferedFinancialApprover();
@@ -54,18 +68,19 @@
 								WfFinancialApproverRecord wfFinancialApproverRecord = (WfFinancialApproverRecord)iterator.next();
 								String financialApprover = wfFinancialApproverRecord.getValue();
 								String userName = wfFinancialApproverRecord.getName();
-								String deleteAction = "manageFinancialApprovers('" + financialApprover + "','" + WfFinancialApproversSection.ACTION_DELETE + "');";
-								String preferedAction = "manageFinancialApprovers('" + financialApprover + "','" + WfFinancialApproversSection.ACTION_PREFERED + "');";
-								String removePreferedAction = "manageFinancialApprovers('" + financialApprover + "','" + WfFinancialApproversSection.ACTION_REMOVEPREFERED + "');";
 								
 								String setAsPreferredTitle = fieldMaster.getDisplayText(Section_WfFinApprovers_Fields.WFFINAPPROVERSSETPREFERREDTITLETEXT, true) + ": " + userName;
 								String removeApproverTitle = fieldMaster.getDisplayText(Section_WfFinApprovers_Fields.WFFINAPPROVERSDELETETITLETEXT, true) + ": " + userName;
 								String removePreferredTitle = fieldMaster.getDisplayText(Section_WfFinApprovers_Fields.WFFINAPPROVERS_REMOVEPREFERRED_TITLETEXT, true) + ": " + userName;
-
+								
+								boolean approvesReqs = wfFinancialApproversSection.hasReqApprovalPermission (wfFinancialApproverRecord.getUser());
+								boolean approvesPOs = wfFinancialApproversSection.hasPOApprovalPermission (wfFinancialApproverRecord.getUser());
+								boolean approvesInvoices = wfFinancialApproversSection.hasInvoiceApprovalPermission (wfFinancialApproverRecord.getUser());
 								// This check is to avoid to show the SQ users (as financial approvers) to the regular logged in user. 
 								if (!(!hasViewHiddenObjects && wfFinancialApproverRecord.getUser().isSciquestUser())) {
 %>
-									<html:resultsTableValueRow>
+									<html:phoenixResultsTableValueRow>
+						
 										<html:resultsTableColumnValue>
 <% 											if (StringUtils.safeEquals(preferedFinancialApprover, financialApprover)) {%>
 												<strong><%=HtmlUtils.htmlEncode(userName)%>&nbsp; (<html:fieldText field="<%= Section_WfFinApprovers_Fields.WFFINAPPROVERS_PREFERREDAPPROVER  %>"/>)</strong>
@@ -73,36 +88,77 @@
 												<%=HtmlUtils.htmlEncode(userName)%>
 <%											}%>
 										</html:resultsTableColumnValue>
+										
+										<html:resultsTableColumnValue>
+										</html:resultsTableColumnValue>
+										  	
 										<html:resultsTableColumnValue>
-<%
-											if (!StringUtils.safeEquals(preferedFinancialApprover, financialApprover)) {
-%>										
-											<html:optionalButton
-												fieldName="<%= Section_WfFinApprovers_Fields.WFFINAPPROVERSSETPREFERRED.getInternalName() %>"
-												titleFieldName="<%= setAsPreferredTitle %>"
-												clickEvent="<%= preferedAction %>"
-											/>&nbsp;
-<%											} else { %>
-										   <html:optionalButton
-												fieldName="<%= Section_WfFinApprovers_Fields.WFFINAPPROVERS_REMOVEPREFERRED.getInternalName() %>"
-												titleFieldName="<%= removePreferredTitle %>"
-												clickEvent="<%= removePreferedAction %>"
-											/>&nbsp;
-<%											} %>											
+												<html:phoenixCheckBox
+													name="<%= Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_REQUISITIONAPPROVER %>"
+													value="<%= approvesReqs%>"
+													title="<%= Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_REQUISITIONAPPROVER %>"
+													readOnly="true"
+													hideName="true"/>
+										</html:resultsTableColumnValue>
+										
+										<html:resultsTableColumnValue>
+											<html:phoenixCheckBox
+													name="<%= Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_POAPPROVER %>"
+													value="<%= approvesPOs%>"
+													title="<%= Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_POAPPROVER %>"
+													readOnly="true"
+													hideName="true"/>
+										</html:resultsTableColumnValue>
+										
+										<html:resultsTableColumnValue>
+											<html:phoenixCheckBox
+													name="<%= Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_INVOICEAPPROVER %>"
+													value="<%= approvesInvoices%>"
+													title="<%= Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERS_INVOICEAPPROVER %>"
+													readOnly="true"
+													hideName="true"/>
+										</html:resultsTableColumnValue>
+										
+										<html:resultsTableColumnValue>
+									
+										</html:resultsTableColumnValue>
+										
+										<html:resultsTableColumnValue>
+											<% boolean isSetAsPreferred = StringUtils.safeEquals(preferedFinancialApprover, financialApprover); %>
+											
+											<html:phoenixSplitButtonOptions>
+															
+												<html:phoenixSplitButtonOption name="<%= Section_WfFinApprovers_Fields.WFFINAPPROVERSSETPREFERRED %>"
+													hidden="<%= isSetAsPreferred %>"
+													action="<%= JSFunctionBuilder.getJSFunction("manageFinancialApprovers")
+														.addArgument(financialApprover)
+														.addArgument(WfFinancialApproversSection.ACTION_PREFERED) %>"
+													/>
+													
+													<html:phoenixSplitButtonOption name="<%= Section_WfFinApprovers_Fields.WFFINAPPROVERS_REMOVEPREFERRED %>"
+													hidden="<%= !isSetAsPreferred %>"
+													action="<%= JSFunctionBuilder.getJSFunction("manageFinancialApprovers")
+														.addArgument(financialApprover)
+														.addArgument(WfFinancialApproversSection.ACTION_REMOVEPREFERED) %>"
+													/>
+													
+												<html:phoenixSplitButtonOption name="<%= Section_WfFinApprovers_Fields.WFFINAPPROVERSDELETE %>" 
+													action="<%= JSFunctionBuilder.getJSFunction("manageFinancialApprovers")
+														.addArgument(financialApprover)
+														.addArgument(WfFinancialApproversSection.ACTION_DELETE) %>"
+													/>
+															
+											</html:phoenixSplitButtonOptions>
 											
-											<html:optionalButton 
-												fieldName="<%=Section_WfFinApprovers_Fields.WFFINAPPROVERSDELETE.getInternalName()%>"
-												titleFieldName="<%= removeApproverTitle %>" 
-												clickEvent= "<%=deleteAction%>"
-											/>
 											<html:hiddenElement name="<%=Section_WfFinApprovers_Fields.HEADER_WFFINAPPROVERSNAME.getInternalName()%>" value="<%=financialApprover%>" />
+										
 										</html:resultsTableColumnValue>
 										
 										
-									</html:resultsTableValueRow>
+									</html:phoenixResultsTableValueRow>
 <%								}
 							}
 %>
-						</html:resultsTableLayout>
+						</html:phoenixResultsTableLayout>
 						<html:hiddenElement name="<%=WfFinancialApproversSection.PARAM_APPROVER%>" value="" />
 					</html:foregroundPanel>
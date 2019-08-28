package com.resilience.spring.email;

import org.springframework.stereotype.Component;

@Component
public class CustomerActivationEmail {

	public static String customer_name ="Customer!";

	public static String to;

	public static String subject;

	public static String text = "Your profile with our bank is activated. You may now proceed to create account.\n Happy Banking!";
	
	public static String message= "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
			"<html style=\"width:100%;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\r\n" + 
			" <head> \r\n" + 
			"  <meta charset=\"UTF-8\"> \r\n" + 
			"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \r\n" + 
			"  <meta name=\"x-apple-disable-message-reformatting\"> \r\n" + 
			"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \r\n" + 
			"  <meta content=\"telephone=no\" name=\"format-detection\"> \r\n" + 
			"  <title>New email template 2019-08-27</title> \r\n" + 
			"  <!--[if (mso 16)]>\r\n" + 
			"    <style type=\"text/css\">\r\n" + 
			"    a {text-decoration: none;}\r\n" + 
			"    </style>\r\n" + 
			"    <![endif]--> \r\n" + 
			"  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> \r\n" + 
			"  <!--[if !mso]><!-- --> \r\n" + 
			"  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,700i\" rel=\"stylesheet\"> \r\n" + 
			"  <!--<![endif]--> \r\n" + 
			"  <style type=\"text/css\">\r\n" + 
			"@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:16px!important; line-height:150%!important } h1 { font-size:32px!important; text-align:center; line-height:120%!important } h2 { font-size:26px!important; text-align:center; line-height:120%!important } h3 { font-size:20px!important; text-align:center; line-height:120%!important } h1 a { font-size:32px!important } h2 a { font-size:26px!important } h3 a { font-size:20px!important } .es-menu td a { font-size:16px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button { font-size:16px!important; display:inline-block!important; border-width:15px 30px 15px 30px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } .es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } }\r\n" + 
			"#outlook a {\r\n" + 
			"	padding:0;\r\n" + 
			"}\r\n" + 
			".ExternalClass {\r\n" + 
			"	width:100%;\r\n" + 
			"}\r\n" + 
			".ExternalClass,\r\n" + 
			".ExternalClass p,\r\n" + 
			".ExternalClass span,\r\n" + 
			".ExternalClass font,\r\n" + 
			".ExternalClass td,\r\n" + 
			".ExternalClass div {\r\n" + 
			"	line-height:100%;\r\n" + 
			"}\r\n" + 
			".es-button {\r\n" + 
			"	mso-style-priority:100!important;\r\n" + 
			"	text-decoration:none!important;\r\n" + 
			"}\r\n" + 
			"a[x-apple-data-detectors] {\r\n" + 
			"	color:inherit!important;\r\n" + 
			"	text-decoration:none!important;\r\n" + 
			"	font-size:inherit!important;\r\n" + 
			"	font-family:inherit!important;\r\n" + 
			"	font-weight:inherit!important;\r\n" + 
			"	line-height:inherit!important;\r\n" + 
			"}\r\n" + 
			".es-desk-hidden {\r\n" + 
			"	display:none;\r\n" + 
			"	float:left;\r\n" + 
			"	overflow:hidden;\r\n" + 
			"	width:0;\r\n" + 
			"	max-height:0;\r\n" + 
			"	line-height:0;\r\n" + 
			"	mso-hide:all;\r\n" + 
			"}\r\n" + 
			"</style> \r\n" + 
			" </head> \r\n" + 
			" <body style=\"width:100%;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\"> \r\n" + 
			"  <div class=\"es-wrapper-color\" style=\"background-color:#EEEEEE;\"> \r\n" + 
			"   <!--[if gte mso 9]>\r\n" + 
			"			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\r\n" + 
			"				<v:fill type=\"tile\" color=\"#eeeeee\"></v:fill>\r\n" + 
			"			</v:background>\r\n" + 
			"		<![endif]--> \r\n" + 
			"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\"> \r\n" + 
			"     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"      <td valign=\"top\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"       \r\n" + 
			"\r\n" + 
			"	   \r\n" + 
			"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \r\n" + 
			"         <tr style=\"border-collapse:collapse;\"></tr> \r\n" + 
			"         <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"           <table class=\"es-header-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#044767;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#044767\" align=\"center\"> \r\n" + 
			"             <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"              <td align=\"left\" style=\"Margin:0;padding-top:35px;padding-bottom:35px;padding-left:35px;padding-right:35px;\"> \r\n" + 
			"               <!--[if mso]><table width=\"530\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"340\" valign=\"top\"><![endif]--> \r\n" + 
			"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \r\n" + 
			"                 <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                  <td class=\"es-m-p0r es-m-p20b\" width=\"340\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td class=\"es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;\"><h1 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:36px;font-style:normal;font-weight:bold;color:#FFFFFF;\">Iron Bank of Braavos</h1></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                   </table></td> \r\n" + 
			"                 </tr> \r\n" + 
			"               </table> \r\n" + 
			"               <!--[if mso]></td><td width=\"20\"></td><td width=\"170\" valign=\"top\"><![endif]--> \r\n" + 
			"               <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                 <tr class=\"es-hidden\" style=\"border-collapse:collapse;\"> \r\n" + 
			"                  <td class=\"es-m-p20b\" width=\"170\" align=\"left\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px;\"> \r\n" + 
			"                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                         <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                          <td style=\"padding:0;Margin:0px;border-bottom:1px solid #044767;background:rgba(0, 0, 0, 0) none repeat scroll 0% 0%;height:1px;width:100%;margin:0px;\"></td> \r\n" + 
			"                         </tr> \r\n" + 
			"                       </table></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td style=\"padding:0;Margin:0;\"> \r\n" + 
			"                       <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                       </table></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td align=\"center\" style=\"padding:0;Margin:0;\"><img class=\"adapt-img\" src=\"https://qweeh.stripocdn.email/content/guids/9cb95d93-ef52-4d7e-8ef7-ede1c1838abf/images/23281566916062306.jpg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\" width=\"140\"></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                   </table></td> \r\n" + 
			"                 </tr> \r\n" + 
			"               </table> \r\n" + 
			"               <!--[if mso]></td></tr></table><![endif]--></td> \r\n" + 
			"             </tr> \r\n" + 
			"           </table></td> \r\n" + 
			"         </tr> \r\n" + 
			"       </table> \r\n" + 
			"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \r\n" + 
			"         <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"           <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \r\n" + 
			"             <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:35px;padding-right:35px;padding-top:40px;\"> \r\n" + 
			"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                 <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                  <td width=\"530\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td class=\"es-m-txt-l\" align=\"left\" style=\"padding:0;Margin:0;padding-top:15px;\"><h3 style=\"Margin:0;line-height:22px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:18px;font-style:normal;font-weight:bold;color:#333333;\">Hello " + CustomerActivationEmail.customer_name + "</h3></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:10px;padding-top:15px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:24px;color:#777777;\">"+ text +"</p></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px;padding-top:20px;\"> \r\n" + 
			"                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                         <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                          <td style=\"padding:0;Margin:0px;border-bottom:3px solid #EEEEEE;background:rgba(0, 0, 0, 0) none repeat scroll 0% 0%;height:1px;width:100%;margin:0px;\"></td> \r\n" + 
			"                         </tr> \r\n" + 
			"                       </table></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                   </table></td> \r\n" + 
			"                 </tr> \r\n" + 
			"               </table></td> \r\n" + 
			"             </tr> \r\n" + 
			"             <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"              <td align=\"left\" style=\"Margin:0;padding-top:30px;padding-bottom:35px;padding-left:35px;padding-right:35px;\"> \r\n" + 
			"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                 <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                  <td width=\"530\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:24px;color:#777777;\">The Better Way To</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:24px;color:#777777;\"><b>Bank</b><br></p></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px;padding-top:30px;\"><span class=\"es-button-border\" style=\"border-style:solid;border-color:transparent;background:#ED8E20 none repeat scroll 0% 0%;border-width:0px;display:inline-block;border-radius:5px;width:auto;\"><a href=\"https://iron-bank-of-braavos-daa23.firebaseapp.com/\" class=\"es-button\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:18px;color:#FFFFFF;border-style:solid;border-color:#ED8E20;border-width:15px 30px;display:inline-block;background:#ED8E20 none repeat scroll 0% 0%;border-radius:5px;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center;\">Access Bank Website</a></span></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                   </table></td> \r\n" + 
			"                 </tr> \r\n" + 
			"               </table></td> \r\n" + 
			"             </tr> \r\n" + 
			"           </table></td> \r\n" + 
			"         </tr> \r\n" + 
			"       </table> \r\n" + 
			"       \r\n" + 
			"       <table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\"> \r\n" + 
			"         <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"           <table class=\"es-footer-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;border-top:10px solid #48AFB5;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \r\n" + 
			"             <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"              <td align=\"left\" style=\"Margin:0;padding-top:35px;padding-left:35px;padding-right:35px;padding-bottom:40px;\"> \r\n" + 
			"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                 <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                  <td width=\"530\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \r\n" + 
			"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px;\"><img src=\"https://qweeh.stripocdn.email/content/guids/CABINET_75694a6fc3c4633b3ee8e3c750851c02/images/12331522050090454.png\" alt=\"Iron Bank Symbol\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\" title=\"Iron Bank Symbol\" width=\"37\"></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                     <tr style=\"border-collapse:collapse;\"> \r\n" + 
			"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;\"><strong>Iron Bank </strong></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;\"><strong>Braavos</strong></p></td> \r\n" + 
			"                     </tr> \r\n" + 
			"                   </table></td> \r\n" + 
			"                 </tr> \r\n" + 
			"               </table></td> \r\n" + 
			"             </tr> \r\n" + 
			"           </table></td> \r\n" + 
			"         </tr> \r\n" + 
			"		 \r\n" + 
			"		 \r\n" + 
			"		 \r\n" + 
			"		 \r\n" + 
			"       </td> \r\n" + 
			"     </tr> \r\n" + 
			"   </table> \r\n" + 
			"  </div>  \r\n" + 
			" </body>\r\n" + 
			"</html>";

	public static String getCustomer_name() {
		return customer_name;
	}

	public static void setCustomer_name(String customer_name) {
		CustomerActivationEmail.customer_name = customer_name;
	}

	public static String getTo() {
		return to;
	}

	public static void setTo(String to) {
		CustomerActivationEmail.to = to;
	}

	public static String getSubject() {
		return subject;
	}

	public static void setSubject(String subject) {
		CustomerActivationEmail.subject = subject;
	}

	public static String getText() {
		return text;
	}

	public static void setText(String text) {
		CustomerActivationEmail.text = text;
	}

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		CustomerActivationEmail.message = message;
	}

	
}

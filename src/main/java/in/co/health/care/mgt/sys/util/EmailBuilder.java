package in.co.health.care.mgt.sys.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import in.co.health.care.mgt.sys.entity.LineItemEntity;

public class EmailBuilder {

	public static String getForgetPasswordMessage(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Your password is reccovered !! " + map.get("firstName") + " " + map.get("lastName") + "</H1>");
		msg.append("<P><B>To access account user Login Id : " + map.get("login") + "<BR>" + " Password : "
				+ map.get("password") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	public static String getUserRegistration(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Welcome to HMS Your Registation Completed</H1>");
		msg.append("<H3>Your Registation Detail  !! " + map.get("firstName") + " " + map.get("lastName") + "</H3>");
		msg.append("<P><B>To access account user Login Id : " + map.get("login") + "<BR>" + " Password : "
				+ map.get("password") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	public static String getUpdatePrecription(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Welcome to HMS Your Upated Prescription</H1>");
		msg.append("<H3>Your Prescription detail : </h3>");
		msg.append("<P><B>" + map.get("prescription") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	public static String getUserOrder(long orderId, List<LineItemEntity> list) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><head><style type=\"text/css\">\r\n" + "body {\r\n" + "	background: grey;\r\n" + "}\r\n"
				+ "</style>" + "" + "<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\">" + "</head><BODY>");
		msg.append("<H1>Welcome to HMS</H1>");
		msg.append("<H3> Your Order Deatail</h3>");

		msg.append("	<div class=\"container\">\r\n" + "		<div class=\"row\">\r\n"
				+ "			<div class=\"col-12\">\r\n" + "				<div class=\"card\">\r\n"
				+ "					<div class=\"card-body\">\r\n"
				+ "						<div class=\"row\" style=\"margin: 5px\">\r\n"
				+ "							<div class=\"col-md-6 text-right\">");

		msg.append("<p class=\"font-weight-bold mb-1\">Invoice #");

		msg.append(orderId + "</p>");

		msg.append("<p class=\"text-muted\">" + new Date() + "</p>");

		msg.append("</div></div>");

		msg.append("<div class=\"row \">\r\n" + "							<div class=\"col-md-12\">\r\n"
				+ "								<table class=\"table\" style=\"border: 1\" >\r\n"
				+ "									<thead>\r\n" + "										<tr>\r\n"
				+ "											<th class=\"border-0 text-uppercase small font-weight-bold\">#</th>\r\n"
				+ "											<th class=\"border-0 text-uppercase small font-weight-bold\">Item</th>\r\n"
				+ "											<th class=\"border-0 text-uppercase small font-weight-bold\">Quantity</th>\r\n"
				+ "											<th class=\"border-0 text-uppercase small font-weight-bold\">UnitCost</th>\r\n"
				+ "											<th class=\"border-0 text-uppercase small font-weight-bold\">Total</th>\r\n"
				+ "										</tr>\r\n" + "									</thead>\r\n"
				+ "									<tbody>");
		double subTotal = 0;
		int i = 1;
		for (LineItemEntity entity : list) {
			msg.append("<tr>");
			msg.append("<td scope=\"row\">" + (i++) + "</td>");
			msg.append("<td scope=\"row\">" + entity.getItemName() + "</td>");
			msg.append("<td scope=\"row\">" + entity.getQuantity() + "</td>");
			msg.append("<td scope=\"row\">" + entity.getUnitPrice() + "</td>");
			msg.append("<td scope=\"row\">" + entity.getTotalAmount() + "</td>");
			msg.append("</tr>");
			subTotal += entity.getTotalAmount();
		}
		msg.append("</tbody>\r\n" + "								</table>\r\n"
				+ "							</div>\r\n" + "						</div>");

		msg.append("<div class=\"d-flex flex-row-reverse bg-dark text-white p-4\">\r\n"
				+ "							<div class=\"py-3 px-5 text-right\">\r\n"
				+ "								<div class=\"mb-2\">Grand Total</div>");
		msg.append("<div class=\"h2 font-weight-light\">" + subTotal + "</div>");
		msg.append("</div>\r\n" + "						</div>\r\n" + "					</div>\r\n"
				+ "				</div>\r\n" + "			</div>\r\n" + "		</div>\r\n" + "\r\n" + "	</div>\r\n"
				+ "</div>");

		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	public static String getUserOrder1(long orderId, List<LineItemEntity> list) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML>");
		msg.append("<Head>");
		msg.append("<style>");
		msg.append("table {font-family: arial, sans-serif;border-collapse: collapse;width: 50%;}");
		msg.append("td, th {border: 1px solid #dddddd;text-align: left;padding: 8px;}");
		msg.append("h3{color:blue;}");
		msg.append("tr:nth-child(even) {background-color: #dddddd;}");
		msg.append("</style>");
		msg.append("</Head>");
		msg.append("<BODY>");
		msg.append("<h3>");
		msg.append("Invoice Id # " + orderId);
		msg.append("</h3>");

		msg.append("<table style='border=1;'>");
		msg.append("<tr>");
		msg.append("<th>#</th>");
		msg.append("<th>Item</th>");
		msg.append("<th>Quantity</th>");
		msg.append("<th>UnitCost</th>");
		msg.append("<th>Total</th>");
		msg.append("</tr>");

		double subTotal = 0;
		int i = 1;
		for (LineItemEntity entity : list) {
			msg.append("<tr>");
			msg.append("<td>" + (i++) + "</td>");
			msg.append("<td>" + entity.getItemName() + "</td>");
			msg.append("<td>" + entity.getQuantity() + "</td>");
			msg.append("<td>" + entity.getUnitPrice() + "</td>");
			msg.append("<td>" + entity.getTotalAmount() + "</td>");
			msg.append("</tr>");
			subTotal += entity.getTotalAmount();
		}
		msg.append("<tr>");

		msg.append("<td colspan=\"4\">Sub Total :</td>");
		msg.append("<td>" + subTotal + "</td>");
		msg.append("</tr>");

		msg.append("</table>");

		msg.append("</BODY></HTML>");

		return msg.toString();
	}

}

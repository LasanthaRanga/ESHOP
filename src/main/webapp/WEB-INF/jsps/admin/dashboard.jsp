<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="page" value="dashboard" />

<%@ include file="../template/adminHead.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Dash Board</h1>
<!-- CURRENCY-CONVERTER.ORG.UK CURRENCY CHARTS START -->
<div
	style="width: 178px; margin: 0; padding: 0; border: 1px solid #2D6AB4; background: #E6F2FA;">
	<div
		style="width: 174px; text-align: center; margin: 2px; padding: 2px 0px; background: #2D6AB4; font-family:; font-size: 11px; color: #FFFFFF; font-weight: bold; vertical-align: middle;">
		USD/LKR CHARTS <a rel="nofollow"
			style="color: #FFFFFF; text-decoration: none; font-size: 9px;"
			href="https://www.currency-converter.org.uk/currency-rates/convert/USD-LKR-rate.html"
			target="_new" title="USD LKR charts"><i>» More</i></a>
	</div>
	<div style="padding: 2px;">
		<script type="text/javascript">
			var dcf = 'USD';
			var dct = 'LKR';
			var mcol = '2D6AB4';
			var mbg = 'E6F2FA';
			var tc = 'FFFFFF';
			var tz = 'userset';
		</script>
		<script type="text/javascript"
			src="https://www.currency-converter.org.uk/widget/CCUK-CHART-1.php"></script>
	</div>
</div>
<!-- CURRENCY-CONVERTER.ORG.UK CURRENCY CHARTS END -->

<%@ include file="../template/adminFoot.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>Register your shop</title>
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
<%@include file="/WEB-INF/jsp/common/scripts.jsp" %>
<script type="text/javascript">
var streetNumber, locality, city, state, country, addressLine1, 
	roadName, pincode, latitude, longitude;
var geocoder;
var addressArray=[];
var address = "";
var flag = false;
if (navigator.geolocation) {
  navigator.geolocation.getCurrentPosition(successFunction, errorFunction);
}
//Get the latitude and the longitude;
function successFunction(position) {
	latitude = position.coords.latitude;
	longitude = position.coords.longitude;
	console.log(latitude +", "+ longitude);
	codeLatLng(latitude, longitude);
}

function errorFunction() {
  console.log("Geocoder failed");
}

function codeLatLng(lat, lng) {
	
	var latlng = new google.maps.LatLng(lat, lng);
	
	geocoder.geocode({
	'latLng': latlng
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			if (results[1]) {
				flag = true;
				for (var i = 0; i < results[0].address_components.length; i++) {
					for (var b = 0; b < results[0].address_components[i].types.length; b++) {
						if (results[0].address_components[i].types[b] == "administrative_area_level_2") {
							city = results[0].address_components[i];
							console.log("City:::::>>>>>"+city.long_name);
							city = city.long_name;
							break;
						}
				
						if (results[0].address_components[i].types[b] == "sublocality_level_2") {
							locality = results[0].address_components[i];
							console.log("Locality:::::>>>>>"+locality.long_name);
							locality = locality.long_name;
							break;
						}
				
						if (results[0].address_components[i].types[b] == "country") {
							country = results[0].address_components[i];
							console.log("country:::::>>>>>"+country.long_name);
							country = country.long_name;
							break;
						}

						if (results[0].address_components[i].types[b] == "street_number") {
							streetNumber = results[0].address_components[i];
							console.log("street_number:::::>>>>>"+streetNumber.long_name);
							streetNumber = streetNumber.long_name;
							break;
						}
				
						if (results[0].address_components[i].types[b] == "route") {
							roadName = results[0].address_components[i];
							console.log("roadName:::::>>>>>"+roadName.long_name);
							roadName = roadName.long_name;
							break;
						}
				
						if (results[0].address_components[i].types[b] == "neighborhood") {
							addressLine1 = results[0].address_components[i];
							console.log("addressLine1:::::>>>>>"+addressLine1.long_name);
							addressLine1 = addressLine1.long_name;
							break;
						}
						
						if (results[0].address_components[i].types[b] == "administrative_area_level_1") {
							state = results[0].address_components[i];
							console.log("State:::::>>>>>"+state.long_name);
							state = state.long_name;
							break;
						}
						
						if (results[0].address_components[i].types[b] == "postal_code") {
							pincode = results[0].address_components[i];
							console.log("pincode:::::>>>>>"+pincode.long_name);
							pincode = pincode.long_name;
							break;
						}
					}
				}
			} else {
				console.log("City name not available");
			}
		} else {
			console.log("Geocoder failed due to: ", status);
		}
		if(flag){
			addressArray.push(streetNumber, roadName, addressLine1, locality, city, pincode, state, country);
			for(var i=0; i< addressArray.length; i++){
				if(addressArray[i] != '' && addressArray[i] != undefined){
					address = address + addressArray[i]+", ";
				}
			}
			console.log("Address------->"+address);
			populateElements();
		}
	});
}

function initialize() {
  geocoder = new google.maps.Geocoder();
}

function populateElements(){
	if(addressLine1 != '' && addressLine1 != undefined){
		$('#landmarkName').val(addressLine1);
	}
	
	if((streetNumber != '' &&  streetNumber != undefined) && (roadName != '' &&  roadName != undefined)){
		$('#streetName').val(streetNumber + ", " + roadName);
	} else if (streetNumber != '' &&  streetNumber != undefined){
		$('#streetName').val(streetNumber);
	} else if (roadName != '' &&  roadName != undefined){
		$('#streetName').val(roadName);
	}
	
	if(locality != '' &&  locality != undefined){
		$('#localityName').val(locality);	
	}
	if(city != '' &&  city != undefined){
		$('#city').val(city);	
	}
	if(state != '' &&  state != undefined){
		$('#state').val(state);	
	}
	if(country != '' &&  country != undefined){
		$('#country').val(country);	
	}
	if(pincode != '' &&  pincode != undefined){
		$('#pincode').val(pincode);	
	}
	if((latitude != '' &&  latitude != undefined) && (longitude != '' &&  longitude != undefined)){
		$('#locationCoOrdinates').val(latitude +", "+ longitude);	
	}
}

document.addEventListener('DOMContentLoaded', function() {
  initialize();
}, false);
</script>
<script src="https://maps.googleapis.com/maps/api/js?sensor=false&key=AIzaSyDg4kddVaGQNI5O5Cx5eOpGBO0X8ODTL-U"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#establishDate").datepicker({
		changeMonth: true,
	    changeYear: true,
	    dateFormat: 'yy/mm/dd'
	});
});
</script>
</head>
<body>
	<form:form action="shopRegistration.do" method="post" modelAttribute="shop" name="shopRegForm" id="shopRegForm">
		<table cellpadding="2" width="20%" bgcolor="99FFFF" align="center"
			cellspacing="2">
			<tr>
				<td colspan=2>
					<center>
						<font size=4><b>Shop Registration Form</b></font>
					</center>
				</td>
			</tr>
			<tr>
				<td>Shop Name</td>
				<td><input type=text name=shopName id="shopName"></td>
			</tr>

			<tr>
				<td>SN Number</td>
				<td><input type="text" name="snNumber" id="snNumber"></td>
			</tr>
			<tr>
				<td>Building Name</td>
				<td><input type="text" name="buildingName" id="buildingName" size="30"></td>
			</tr>
			
			<tr>
				<td>Landmark Name</td>
				<td><input type="text" name="landmarkName"
					id="landmarkName" size="30"></td>
			</tr>

			<tr>
				<td>Street Name</td>
				<td><input type="text" name="streetName"
					id="streetName" size="30"></td>
			</tr>
			
			<tr>
				<td>Locality/Area</td>
				<td><input type="text" name="localityName"
					id="localityName" size="30"></td>
			</tr>
			
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="ownerGender" id="ownerGender" value="M" size="10">Male
					<input type="radio" name="ownerGender" id="ownerGender" value="F" size="10">Female</td>
			</tr>

			<tr>
				<td>City</td>
				<td>
					<input type="text" name="city" id="city" size="30">
				</td>
			</tr>
			<tr>
				<td>District</td>
				<td>
					<input type="text" name="district" id="district" size="30">
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<input type="text" name="state" id="state" size="30">
				</td>
			</tr>
			<tr>
				<td>Country</td>
				<td>
					<input type="text" name="country" id="country" size="30">
				</td>
			</tr>

			<tr>
				<td>PinCode</td>
				<td><input type="text" name="pincode" id="pincode" size="30"></td>
			</tr>
			
			<tr>
				<td>Name of Owner</td>
				<td><input type="text" name="ownerName" id="ownerName" size="30"></td>
			</tr>
			
			<tr>
				<td>Shop License/Registration Number</td>
				<td><input type="text" name="registrationNumber" id="registrationNumber" size="30"></td>
			</tr>
			
			<tr>
				<td>EmailId</td>
				<td><input type="text" name="emailId" id="emailId" size="30"></td>
			</tr>
			
			<tr>
				<td>User Id</td>
				<td><input type="text" name="userId" id="userId" size="30"></td>
			</tr>

			<tr>
				<td>Date Of Establishment</td>
				<td><input type="text" name="establishDate" id="establishDate" size="30"></td>
			</tr>

			<tr>
				<td>Primary Contact No</td>
				<td><input type="text" name="primaryContactNumber" id="primaryContactNumber" size="30"></td>
			</tr>
			
			<tr>
				<td>Contact No</td>
				<td><input type="text" name="contactNumber" id="contactNumber" size="30"></td>
			</tr>
			
			<tr>
				<td>Ownership Detail</td>
				<td><select Name="ownership" id="ownership">
						<option value="SELECT" selected>SELECT</option>
						<option value="SELF">Self</option>
						<option value="RENTAL">Rental</option>
				</select></td>
			</tr>

			<tr>
				<td>Tenant Name</td>
				<td><input type="text" name="tenantName" id="tenantName" size="30"></td>
			</tr>
			
			<tr>
				<td>Tenant Gender</td>
				<td><input type="radio" name="tenantGender" id="tenantGender" value="M" size="10">Male
					<input type="radio" name="tenantGender" id="tenantGender" value="F" size="10">Female</td>
			</tr>
			
			<tr>
				<td>Establishment Type</td>
				<td><select Name="establishType" id="establishType">
						<option value="SELECT" selected>SELECT</option>
						<option value="SELF">SELF OWNED</option>
						<option value="PRT">PARTNERSHIP</option>
						<option value="PVT">PVT LTD</option>
						<option value="COOP">Co-OPERATIVE</option>
						<option value="PUB">PUBLIC LTD</option>
						<option value="RNTL">RENTAL</option>
						<option value="TRST">TRUST</option>
				</select></td>
			</tr>
			
			<tr>
				<td>Business Sector</td>
				<td><select Name="businessSector" id="businessSector">
						<option value="SELECT" selected>SELECT</option>
						<option value="PVT">PRIVATE</option>
						<option value="PUB">PUBLIC</option>
				</select></td>
			</tr>
			
			<tr>
				<td>LocationCo-Ordinates</td>
				<td><input type="text" name="locationCoOrdinates" id="locationCoOrdinates" size="30"></td>
			</tr>
			
			<tr>
				<td>Working Hours</td>
				<td><input type="text" name="workingHours" id="workingHours" size="30"></td>
			</tr>

			<tr>
				<td>Working Days</td>
				<td><input type="text" name="workingDays" id="workingDays" size="30"></td>
			</tr>
			
			<tr>
				<td>Holiday</td>
				<td><input type="text" name="workingOffDays" id="workingOffDays" size="30"></td>
			</tr>
			
			<tr>
				<td><input type="reset"></td>
				<td colspan="2"><input type="submit" id="submit" value="Submit Form" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
<div class="header">
	<input name="localeFileName" id="localeFileName" type="hidden" value="${homePageFormBean.localeFileName}">
	
	<c:choose>
		<c:when test="${not empty homePageFormBean.localeFileName}">
			<fmt:setBundle basename="${homePageFormBean.localeFileName}"
				var="selectLanguage"></fmt:setBundle>
		</c:when>
		<c:otherwise>
			<fmt:setBundle basename="com.properties.ApplicationMessages"
				var="selectLanguage"></fmt:setBundle>
		</c:otherwise>
	</c:choose>
	
	<table>
		<tr>
			<td>Search:<input type="text" name="searchBox" id="searchBox"
				placeholder="Search Area">
			</td>
			<td>User Name:<input type="text" name="userName" id="userName"
				placeholder="Enter User Name">
			</td>
			<td>Password:<input type="text" name="password" id="password"
				placeholder="password">
			</td>
			<td>Location:<input type="text" name="currentLocation"
				id="currentLocation" placeholder="Your Location">
			</td>

			<td><select id="localeLanguage" name="localeLanguage"
				onchange="submitForm('homePageForm')">
					<option id="SEL">SELECT</option>
					<option id="ENG">ENGLISH</option>
					<option id="GUJ">GUJARATI</option>
					<option id="HIN">HINDI</option>
			</select></td>			
		</tr>
	</table>
</div>

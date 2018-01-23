<div class="header">
	<input name="localeFileName" id="localeFileName" type="hidden" value="${homePageFormBean.localeFileName}">
	
	<c:choose>
		<c:when test="${not empty homePageFormBean.localeFileName}">
			<fmt:setBundle basename="${homePageFormBean.localeFileName}"
				var="selectLanguage"></fmt:setBundle>
		</c:when>
		<c:otherwise>
			<fmt:setBundle basename="com.properties.ApplicationMessages_en_IN"
				var="selectLanguage"></fmt:setBundle>
		</c:otherwise>
	</c:choose>
	
	<table>
		<tr>
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
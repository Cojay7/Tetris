<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="h1" value="FAQ" />

	<tiles:putAttribute name="content">

		<form:form method="post" modelAttribute="faq">
			<div class="container">
				<h4>Ajouter ou modifier une FAQ</h4>

				<div class="form-group">
					<label for="question">Question :</label> <input name="question"
						type="text" class="form-control" id="question"
						value="${faq.question}" placeholder="Question">
					<form:errors path="question" element="div"
						cssClass="alert alert-warning" />

				</div>
				<div class="form-group">
					<label for="reponse">Réponse :</label> <input name="reponse"
						type="text" class="form-control" id="reponse"
						value="${faq.reponse }" placeholder="Réponse">
					<form:errors path="reponse" element="div"
						cssClass="alert alert-warning" />


				</div>


				<button type="submit" class="btn btn-primary btn-lg">Envoyer</button>
			</div>
		</form:form>
	</tiles:putAttribute>


</tiles:insertDefinition>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="h1" value="Tetrimino" />

	<tiles:putAttribute name="content">

		<form:form method="post" modelAttribute="tetrimino">
			<div class="container">
				<h4>Ajouter ou modifier un Tetrimino</h4>

				<div class="form-group">
					<label for="nom">Nom :</label> <input name="nom" type="text"
						class="form-control" id="nom" value="${tetrimino.nom}"
						placeholder="Nom">


				</div>
				<div class="form-group">
					<label for="couleur">Couleur</label> <SELECT NAME="couleur"
						id="couleur" value="${tetrimino.couleur}">
						<option value="-" label="--Please Select" />
												
						<OPTION VALUE="Rouge"
							STYLE="background-color: #CC0000">
				
						<OPTION VALUE="Vert"
							STYLE="color: #FFFFFF; background-color: #336633">
						<OPTION VALUE="Gris"
							STYLE="color: #FFFFFF; background-color: #868486">
						<OPTION VALUE="Bleu"
							STYLE="color: #FFFFFF; background-color: #336699">
						<OPTION VALUE="Noir"
							STYLE="color: #FFFFFF; background-color: #000000">
					</select>

				</div>


				<button type="submit" class="btn btn-primary">Envoyer</button>
			</div>
		</form:form>
	</tiles:putAttribute>


</tiles:insertDefinition>
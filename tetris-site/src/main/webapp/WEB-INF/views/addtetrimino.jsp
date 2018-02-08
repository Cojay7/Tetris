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
				<br>
				<div class="form-group">
					<label for="couleur">Couleur</label> 
						<c:if test="${tetrimino.couleur != null}">
						<input type = "color" class="bfh-colorpicker">
			<%-- 			<SELECT NAME="couleur"
						id="couleur" value="${tetrimino.couleur}"> --%>
							<%-- <option value="${tetrimino.couleur}" label="${tetrimino.couleur}" />
							<OPTION VALUE="rouge"
								STYLE="color: #FFFFFF; background-color: #CC0000">
							<OPTION VALUE="vert"
								STYLE="color: #FFFFFF; background-color: #336633">
							<OPTION VALUE="gris"
								STYLE="color: #FFFFFF; background-color: #868486">
							<OPTION VALUE="bleu" class="btn btn-primary"
								STYLE="color: #FFFFFF; background-color: #336699">
							<OPTION VALUE="noir"
								STYLE="color: #FFFFFF; background-color: #000000"> --%>
						</c:if>
						<c:if test="${tetrimino.couleur == null}">
						<input type = "color" class="bfh-colorpicker">
							<!-- <option value="-" label="--Please Select" />
							<OPTION VALUE="rouge"
								STYLE="color: #FFFFFF; background-color: #CC0000">
							<OPTION VALUE="vert"
								STYLE="color: #FFFFFF; background-color: #336633">
							<OPTION VALUE="gris"
								STYLE="color: #FFFFFF; background-color: #868486">
							<OPTION VALUE="bleu" class="btn btn-primary"
								STYLE="color: #FFFFFF; background-color: #336699">
							<OPTION VALUE="noir"
								STYLE="color: #FFFFFF; background-color: #000000"> -->
								<!-- </select> -->
						</c:if>
					 </br>
				</div>

				<br>
				<div class="form-group">
				<label >Forme : </label>
				<br/>
					<table>
						<c:forEach var="i" begin="1" end="${ taille }">
							<tr>
								<c:forEach var="j" begin="1" end="${taille}">
									<td><input type="checkbox" id="${i}.${j}" name="${i}.${j}"></td>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
				</div>

				</br>
				<button type="submit" class="btn btn-primary btn-lg">Envoyer</button>
			</div>
		</form:form>
	</tiles:putAttribute>


</tiles:insertDefinition>
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
						<input type="color" class="bfh-colorpicker"
							value="${tetrimino.couleur}" name="couleur"
							label="${tetrimino.couleur}">

					</c:if>
					<c:if test="${tetrimino.couleur == null}">
						<input type="color" class="bfh-colorpicker"
							value="${tetrimino.couleur}" name="couleur"
							label="${tetrimino.couleur}">

					</c:if>
					</br>
				</div>

				<br>
				<div class="form-group">
					<label>Forme : </label> <br />
					<table>
						<c:forEach var="a" begin="1" end="5" step="1">
							<tr>
								<c:forEach var="b" begin="1" end="5" step="1">
									<td><input type="checkbox" id="coord" name="${a}.${b}"
										style="height: 20px; width: 20px"></td>
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
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
					<form:errors path="nom" element="div"
						cssClass="alert alert-warning" />

				</div>
				<br>
				<div class="form-group">
					<label for="couleur">Couleur</label>
					<c:if test="${tetrimino.couleur != null}">
						<input type="color" class="bfh-colorpicker"
							value="${tetrimino.couleur}" name="couleur">

					</c:if>
					<c:if test="${tetrimino.couleur == null}">
						<input type="color" class="bfh-colorpicker"
							value="${tetrimino.couleur}" name="couleur">

					</c:if>
					</br>
				</div>

				<br>
				<div class="form-group">
					<label for="forme">Forme : </label> <br />
					<table>
						<c:forEach var="a" begin="0" end="4" step="1">
							<tr>
								<c:forEach var="b" begin="0" end="4" step="1">
									<td><input class="check" type="checkbox" id="${a}.${b}"
										name="${a}.${b}"<c:if test="${matrice[a][b] == 1}" >checked</c:if>> <label
										for="${a}.${b}"></label></td>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
					<br />
					<form:errors path="forme_1rota" element="div"
						cssClass="alert alert-warning" />

				</div>

				</br>
				<button type="submit" class="btn btn-primary btn-lg">Envoyer</button>
			</div>
		</form:form>
	</tiles:putAttribute>


</tiles:insertDefinition>
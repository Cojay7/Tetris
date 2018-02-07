<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="h1" value="Tetrimino" />

	<tiles:putAttribute name="content">

		<div class="container">

			<h4>Liste des tetriminos</h4>
			<table class="table table-striped">
				<tr>
					<th>Nom</th>
					<th>Couleur</th>
					<th>Forme</th>
					<th>Option</th>
					<th>Etat</th>
				</tr>
				<c:forEach items="${tetriminos}" var="tetrimino">

					<tr>
						<td value="Nom">${ tetrimino.nom }</td>
						<td value="Couleur">${ tetrimino.couleur }</td>

						<td>
							<table>
								<c:forTokens items="${tetrimino.forme_1rota}" var="ligne"
									delims="/">
									<tr>
										<c:forTokens items="${ligne}" var="colonn" delims=",">
											<c:if test="${colonn==1 }">
												<td class="bg-primary"></td>
											</c:if>
											<c:if test="${colonn==0}">
												<td class="table-light"></td>
											</c:if>
											<%-- <c:out value="${colonn}" /> --%>
										</c:forTokens>
								</c:forTokens>
							</table>
						</td>
						<td><a href="/tetris-site/tetrimino/edit?id=${tetrimino.id}"
						
							class="btn btn-outline-success">Modifier</a>
						
						<a
							href="/tetris-site/tetrimino/delete?id=${tetrimino.id}"
							class="btn btn-outline-danger">Supprimer</a></td>
						<td><a
							href="/tetris-site/tetrimino/activ?id=${tetrimino.id}"
							class="btn btn-warning">Activer</a></td>
					</tr>
				</c:forEach>

			</table>
			<a href="/tetris-site/tetrimino/add" class="btn btn-outline-primary btn-lg">Ajout</a>

		</div>

	</tiles:putAttribute>


</tiles:insertDefinition>
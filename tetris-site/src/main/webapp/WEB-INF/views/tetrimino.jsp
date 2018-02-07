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

				<c:forEach items="${tetriminos}" var="tetrimino">
					<tr>
						<td>${ tetrimino.nom }</td>
						<td>${ tetrimino.couleur }</td>
						<td><a href="/tetris-site/tetrimino/edit?id=${tetrimino.id}"
							class="btn btn-outline-success">Modifier</a></td>
						<td><a
							href="/tetris-site/tetrimino/delete?id=${tetrimino.id}"
							class="btn btn-outline-danger">Supprimer</a></td>
					</tr>
				</c:forEach>

			</table>
			<a href="/tetris-site/tetrimino/add" class="btn btn-outline-primary">Ajout</a>

		</div>

	</tiles:putAttribute>


</tiles:insertDefinition>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="h1" value="Tetrimino" />

	<tiles:putAttribute name="content">

		<form:form method="GET"  action="/tetris-site/tetrimino/add">
			<div class="container">
				<h4>Taille du tetrimino</h4>

				<div class="form-group">
					<label>Taille :</label> <input name="taille" type="number"
						class="form-control" id="taille" value="taille"
						placeholder="Veuillez entre une taille">


				</div>
			
				
				<button type="submit" class="btn btn-primary btn-lg">Envoyer</button>
			</div>
		</form:form>
	</tiles:putAttribute>


</tiles:insertDefinition>
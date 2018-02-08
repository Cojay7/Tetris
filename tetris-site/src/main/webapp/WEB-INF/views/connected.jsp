<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="h1" value="Connecté" />
	<tiles:putAttribute name="content">


		<p>Bienvenue ${ login } (id = ${ utilisateur.id } statut = ${ statut } ) </p>

	</tiles:putAttribute>
</tiles:insertDefinition>

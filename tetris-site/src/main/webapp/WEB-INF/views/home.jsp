<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Bienvenue" />
	<tiles:putAttribute name="h1">Tetris</tiles:putAttribute>
	<tiles:putAttribute name="content">

		<h4>Règles du jeu</h4>
		
<h6><em>Le jeu est basé sur le jeu classique TETRIS. Le but est de placer des formes (7 formes cubiques différentes) qui descendent du haut vers la bas d'un tableau pour en former des lignes horizontales pleines. Dès qu'elle est pleine, la ligne est détruite et tous les cubes au-dessus de la ligne descendent d'une rangée.

Les touches de directions (flèches) sont utilisées pour le déplacement et la barre d'espacement permet d'accélérer la descente des pièces. Les flèches droite et gauche pour contrôler horizontalement la forme qui descend. Les flèches du haut et bas pour contrôler la rotation de la forme.

A chaque multiple de cinq lignes complétées, le niveau de difficulté augmente de 1 et la vitesse de descente également.

Le jeu se termine lorsqu'il n'est plus possible de faire descendre des formes sur le tableau.

Attribution des points :
(1 point * niveau de difficulté) est attribuée lorsqu'une forme est placée sur le tableau ainsi qu'à chaque rangée descendu par la forme lors de l'utilisation de la barre d'espacement.

100 points sont attribués lorsqu'une ligne est complétée.

Bonne partie !! </em></h6>


	</tiles:putAttribute>
</tiles:insertDefinition>
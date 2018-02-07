<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="h1" value="Connexion" />
	<tiles:putAttribute name="content">

		<p>oybgyguivbyiuhuonouh le contenu</p>

		<form method="POST">
			<div class="container">
				<div class="form-group">
					<label for="login">Login</label> <input type="text"
						class="form-control" name="login">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password">
				</div>

				<button type="submit" class="btn btn-primary">Se connecter</button>
			</div>
		</form>

	</tiles:putAttribute>
</tiles:insertDefinition>

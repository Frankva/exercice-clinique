<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <p>Bonjour ${ auteur.prenom } ${ auteur.nom }
            <c:out value="Bonjour !" />
        </p>
        <c:if test="${ !empty form.resultat }">
            <p><c:out value="${form.resultat}" /></p>
        </c:if>
        <c:if test="${!empty erreur}">
            <p style="color:red;">
                <c:out value="${erreur}"/>
            </p>
        </c:if>
        <form method="post" action="bonjour">
            <p>
                <label for="login">Login : </label>
                <input type="text" id="login" name="login" >
            </p>
            <p>
                <label for="pass">Mot de passe : </label>
                <input type="password" id="pass" name="pass" >
            </p>
             <p>
                <label for="nom">Nom : </label>
                <input type="text" name="nom" id="nom" />
            </p>
            <p>
                <label for="prenom">Prénom : </label>
                <input type="text" name="prenom" id="prenom" />
            </p>
            <input type="submit">
        </form>
        <ul>
            <c:forEach var="utilisateur" items="${ utilisateurs }">
                <li>
                    <c:out value="${ utilisateur.prenom }"/>
                    <c:out value="${ utilisateur.nom }"/>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>

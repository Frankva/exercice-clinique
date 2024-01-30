<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lettre d’information électronique</title>
    <link rel="stylesheet" href="/clinique/bulma.min.css">
  </head>
  <body>
    <%@ include file="menu.jsp" %>
    <section class="section">
      <div class="container">
        <h1 class="title">Lettre d’information électronique</h1>
        <p class="subtitle">
          Inscription
        </p>
        <c:if test="${!empty error}">
            <article class="message is-danger">
              <div class="message-body">
                <c:out value="${error}"/>
              </div>
            </article>
        </c:if>
        <form method="post" action="/clinique/newsletters">
          <div class="field">
            <label class="label" for="firstname">Prénom</label>
            <div class="control">
              <input class="input" type="text" id="firstname" name="firstname">
            </div>
          </div>
          <div class="field">
            <label class="label" for="lastname">Nom</label>
            <div class="control">
              <input class="input" type="text" id="lastname" name="lastname">
            </div>
          </div>
          <div class="field">
            <label class="label" for="email">Courriel</label>
            <div class="control">
              <input class="input" type="email" id="email" name="email">
            </div>
          </div>
          <div class="field is-grouped">
            <div class="control">
              <button class="button is-link">Envoyer</button>
            </div>
            <div class="control">
              <a class="button is-link is-light" href="/clinique">Annuler</a>
            </div>
          </div>
        </form>
        <h2>Liste des inscrits</h2>
        <ul>
            <c:forEach var="email" items="${ emails }">
                <li>
                    <c:out value="${ email.name }"/>
                </li>
            </c:forEach>
        </ul>
      </div>
    </section>
  </body>
</html>

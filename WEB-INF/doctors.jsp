<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Médecins</title>
    <link rel="stylesheet" href="/clinique/bulma.min.css">
  </head>
  <body>
    <%@ include file="menu.jsp" %>
    <section class="section">
      <div class="container">
        <h1 class="title">Médecins</h1>
        <p class="subtitle">
          Ajouter
        </p>
        <c:if test="${!empty erreur}">
            <article class="message is-danger">
              <div class="message-body">
                <c:out value="${erreur}"/>
              </div>
            </article>
        </c:if>
        <form method="post" action="/clinique/doctors">
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
            <label class="label" for="address">Adresse</label>
            <div class="control">
              <input class="input" type="text" id="address" name="address">
            </div>
          </div>
          <div class="field">
            <label class="label" for="phone">Téléphone</label>
            <div class="control">
              <input class="input" type="text" id="phone" name="phone">
            </div>
          </div>
          <div class="field">
            <label class="label" for="specialtyId">Spécialité</label>
            <div class="select">
              <select id="specialtyId" name="specialtyId">
                <c:forEach items="${specialties}" var="specialty">
                  <option value="<c:out value="${specialty.id}" />"><c:out value="${specialty.name}"/></option>
                </c:forEach>
              </select>
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
      </div>
    </section>
  </body>
</html>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Infimiers</title>
    <link rel="stylesheet" href="/clinique/bulma.min.css">
  </head>
  <body>
    <%@ include file="menu.jsp" %>
    <section class="section">
      <div class="container">
        <h1 class="title">Infimiers</h1>
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
        <form method="post" action="/clinique/nurses">
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
            <label class="label" for="rotation">Rotation</label>
            <div class="control">
              <input class="input" type="text" id="rotation" name="rotation">
            </div>
          </div>
          <div class="field">
            <label class="label" for="salary">Salaire</label>
            <div class="control">
              <input class="input" type="text" id="salary" name="salary">
            </div>
          </div>
          <div class="field">
            <label class="label" for="serviceId">Service</label>
            <div class="select">
              <select id="serviceId" name="serviceId">
                <c:forEach items="${services}" var="service">
                  <option value="<c:out value="${service.id}" />"><c:out value="${service.name}"/></option>
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

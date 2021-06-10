<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prova Jallcard</title>

    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Cadastro</h1>
<main>
    <form>
        <label for="nome">Nome *</label>
        <input type="text" id="nome" class="input-padrao" required>

        <label for="sobrenome">Sobrenome *</label>
        <input type="text" id="sobrenome" class="input-padrao" required>

        <label for="datanascimento">Data de nascimento *</label>
        <input type="date" id="datanascimento" class="input-padrao" required placeholder="99/99/9999">

        <label for="telefone">Telefone *</label>
        <input type="tel" id="telefone" class="input-padrao" required placeholder="(XX) XXXXX-XXXX">

        <fieldset>
            <legend>Qual seu parentesco? *</legend>
            <label for="radio-avo"><input type="radio" name="avo" value="parentesco" id="radio-avo"> Avô/ó</label>

            <label for="radio-filho"><input type="radio" name="filho" value="parentesco" id="radio-filho"> Filho/a</label>

            <label for="radio-irmao"><input type="radio" name="irmao" value="parentesco" id="radio-irmao"> Irmão/ã</label>

            <label for="radio-mae"><input type="radio" name="mae" value="parentesco" id="radio-mae"> Mãe</label>

            <label for="radio-primo"><input type="radio" name="primo" value="parentesco" id="radio-primo"> Primo/a</label>

            <label for="radio-tio"><input type="radio" name="tio" value="parentesco" id="radio-tio"> Tio/a</label>

            <label for="radio-pai"><input type="radio" name="pai" value="parentesco" id="radio-pai"> Pai</label>

            <label for="radio-conjuge"><input type="radio" name="conjuge" value="parentesco" id="radio-conjuge"> Conjuge</label>

            <label for="radio-outro"><input type="radio" name="outro" value="parentesco" id="radio-outro"> Outro</label>


        </fieldset>

        <input type="submit" value="Enviar formulário" class="enviar">
    </form>
</main>
</body>
</html>
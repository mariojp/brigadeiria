/*var campo = $("#input-cliente");
campo.on("input", function(){
    console.log(campo.val());
});*/

var botaoAcrescentar = $("#b-acrescentar");
botaoAcrescentar.on("click", function(){
    var nomeProduto = $("#selectProduto option:selected");
    var quantidade = $("#quantidade");
    $("#lista-carrinho").append(" <li class='list-group-item d-flex justify-content-between lh-sm'>" +
                                " <div> " +
                                " <h6 class='my-0'>"+ nomeProduto.text() +"</h6>" +     
                                " </div>" + 
                                " <span class='text-muted'>"+ quantidade.val() + "</span>" + 
                                " </li>");
 
});


$("#categoria" ).change(function() {
selectedOption = $(this).val();
    if (selectedOption === "") {
        $('#selectProduto').prop('disabled', 'disabled').val('');
        $("#selectProduto option").slice(1).remove(); // keep first
    } else {
        $('#selectProduto').prop('disabled', false)
        var orig = $(location).attr('origin');
        var url = "/apiproduto/addSelectProdutoPorCategoria?idCategoria=" + selectedOption;
        $.ajax({
            url: url,
        success: function (response) {
                var len = response.length;
                    $("#selectProduto option[value!='']").remove(); // keep first 
                    for (var i = 0; i < len; i++) {
                        var id = response[i]['id'];
                        var name = response[i]['nome'];
                        var tamanho = response[i]['tamanho']
                        $("#selectProduto").append("<option id='produto' value='" + id + "'>" + name + " " + tamanho+ "</option>");
                    }
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
        });
    }
    }).change();
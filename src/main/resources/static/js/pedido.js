var botaoAcrescentar = $("#b-acrescentar");
botaoAcrescentar.on("click", function(){
    var numeroItens = $("#total-itens").text();
    var nomeProduto = $("#selectProduto option:selected").text();
    var quantidade = $("#quantidade").val();
   

    //Para pegar o tamanho (Se festa, Grande, etc)
    var textoProduto = nomeProduto.split(" "); //é um array
    var produtoFinal = formaProduto(textoProduto);
    console.log("Produto Final" + produtoFinal)
    var tamanho = textoProduto.pop();

    var textoProdutoSemVirgula = nomeProduto.toString().replace("," , " ");
    
    //var url = "/api/apiitem/addItens?quant=" + quantidade + "&produto=" + textoProdutoSemVirgula + "&tamanho=" + tamanho;
    var url = "/api/apiitem/testePost";  
    var dados = {quantidade: quantidade, produto: textoProdutoSemVirgula , tamanho: tamanho};
    console.log(dados);
    var meuJson =  JSON.stringify(dados);

    $.ajax(url,
         {'data':meuJson, 
          'type': 'POST', 
          'processData': false,
          'contentType': 'application/json' })
          
          .done(function(){
            var linhaFinal = adicionaLinha(nomeProduto, quantidade);
            $("#lista-carrinho").prepend(linhaFinal);
            linhaFinal.find(".botao-remover").click(removeLinha);
                                                
            //atualiza quantidade de itens do carrinho
            var novoNumItens =  parseInt(numeroItens) + 1;
            $("#total-itens").text(novoNumItens);   
            ;
            //atualiza preço
            $("#valorTotal").text(data);
            });
       
});

function formaProduto(nomeProduto){

    var i = 0;
    var palavra;
    var quantPalavras = nomeProduto.length;

    while (i<quantPalavras-1){
        if (i=0){
            palavra = nomeProduto[i];
        }else{
            palavra = palavra + nomeProduto[i];
        }
        i= i+1;
    }

    return palavra;
}
    

function adicionaLinha(produto, quantidade){
    var linha = $("<li>").addClass("list-group-item d-flex justify-content-between lh-sm");
    var nomeProduto = $("<h6>").addClass("class='my-0'").text(produto);
    var spanQuantidade = $("<span>").text(quantidade);
    var link = $("<a>").addClass("botao-remover").attr("href", "#").text("Excluir");

    linha.append(nomeProduto);
    linha.append(spanQuantidade);
    linha.append(link);

    return linha;
}

function removeLinha(){
 
    $(this).parent().remove();
 
}


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
                        $("#selectProduto").append("<option id='produto' value='" + id + "'>" + name + " "+ tamanho + "</option>");
                        //$("#selectTamanho").append("<option id='tamanho' value='" + id + "'>" + tamanho + "</option>");
                    }
                },
                error: function (e) {
                    console.log("ERROR : ", e);
                }
        });
    }
    }).change();
    
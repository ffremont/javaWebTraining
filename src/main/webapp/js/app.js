(function ($) {

    function onSubmitForm($event) {
        console.log("> onSubmitForm");
        $event.preventDefault(); // annuler l'événement "submit"
        
        $.ajax({
            url: "rest/weather",
            dataType : "json"
        }).done(function (data) {
            console.log(data);
            
            $(".ecran").toggleClass("hide");
            
            // valorisation des HTML Node
            $("#data-name").text(data.name);
        });
    }
    
    // gestion du clique pour ré-afficher l'écran
    function onClickRetour(){
        $(".ecran").toggleClass("hide");
    }

    $("#formulaire-meteo").on("submit", onSubmitForm);
    $("#retour").on("click", onClickRetour);
}($));
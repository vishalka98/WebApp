// JavaScript source code
$(document).ready(function () {
    $('.dropdown').hover(function()
        {
        $(this).find('.dropdown-menu').stop().slideToggle(2000);
        });
});
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).on("click", "#shadow-sample2, #shadow-sample3", function() {
    var tap = ($(this).data("tap") * 1) + 1;
    if (tap === 6) {
        tap = 0;
    }
    $(this).data("tap", tap);
    var shadow = "shadow-z-" + tap;
    $(this).attr("class", shadow);
});
window.page = window.location.hash || "#about";

$(document).ready(function() {
    if (window.page != "#about") {
        $(".menu").find("li[data-target=" + window.page + "]").trigger("click");
    }
});

$(window).on("resize", function() {
    $("html, body").height($(window).height());
    $(".main, .menu").height($(window).height() - $(".header-panel").outerHeight());
    $(".pages").height($(window).height());
}).trigger("resize");

$(".menu li").click(function() {
    // Menu
    if (!$(this).data("target"))
        return;
    if ($(this).is(".active"))
        return;
    $(".menu li").not($(this)).removeClass("active");
    $(".page").not(page).removeClass("active").hide();
    window.page = $(this).data("target");
    var page = $(window.page);
    window.location.hash = window.page;
    $(this).addClass("active");


    page.show();

    var totop = setInterval(function() {
        $(".pages").animate({scrollTop: 0}, 0);
    }, 1);

    setTimeout(function() {
        page.addClass("active");
        setTimeout(function() {
            clearInterval(totop);
        }, 1000);
    }, 100);
});

function cleanSource(html) {
    var lines = html.split(/\n/);

    lines.shift();
    lines.splice(-1, 1);

    var indentSize = lines[0].length - lines[0].trim().length,
            re = new RegExp(" {" + indentSize + "}");

    lines = lines.map(function(line) {
        if (line.match(re)) {
            line = line.substring(indentSize);
        }

        return line;
    });

    lines = lines.join("\n");

    return lines;
}

$("#opensource").click(function() {
    $.get(window.location.href, function(data) {
        var html = $(data).find(window.page).html();
        html = cleanSource(html);
        $("#source-modal pre").text(html);
        $("#source-modal").modal();
    });
});
$(function() {
    $.material.init();
    $(".shor").noUiSlider({
        start: 40,
        connect: "lower",
        range: {
            min: 0,
            max: 100
        }
    });

    $(".svert").noUiSlider({
        orientation: "vertical",
        start: 40,
        connect: "lower",
        range: {
            min: 0,
            max: 100
        }
    });
});
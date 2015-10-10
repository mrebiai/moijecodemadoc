#!/bin/bash

rm -rf backends
mkdir backends
cd backends
# REVEAL JS
git clone git://github.com/asciidoctor/asciidoctor-reveal.js.git
git clone git://github.com/hakimel/reveal.js.git
# DECK JS
#git clone git://github.com/asciidoctor/asciidoctor-backends.git
#git clone git://github.com/imakewebthings/deck.js.git
# DZSLIDES
#git clone https://github.com/mojavelinux/dzslides.git
cd ..
cp solarized_custom.css backends/reveal.js/css/theme/.


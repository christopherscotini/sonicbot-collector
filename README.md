# sonicbot-collector

Estrategias de Leitura:

- Skimming: Estrategia responsavel por ler resumidamento os jogos de uma determinada data. [Resumo de todos os jogos]
	http://localhost:8082/sbcollector/match/list

- Scanning: Leitor que visa localizar as informações que estamos interessados, devemos ser objetivos e seletivos, porque não se faz necessario ler todas as informações. [Detalhe de cada Partida]
	http://localhost:8082/sbcollector/match/{matchId}

- Prediction: É o coração do projeto, é a inteligencia que deduz quais mercados são bons para aposta.
	+ Hipotese Dupla
	+ Gols
	+ Resultado Final
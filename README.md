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
	
	
========= ANALISES DE DADOS =========
						ENG - PREMIER	ENG - CHAMP	ALE - BUNDE	POR - PRIME	FRA - LIG 1	ITA - SERIE A	ITA - SERIE B	ESP - LA LIGA	ESP - SEGUNDA	AVG
Vitórias equipa Casa	49,47%			45,93%	48,89%	44,87%	49,50%	49,66%	44,60%	47,31%	46,92%	47,46%
Empates 				22,61%			24,40%	23,11%	26,92%	25,75%	19,66%	36,93%	25,45%	31,96%	26,31%
Vitórias equipa Fora	27,92%			29,67%	28,00%	28,21%	24,75%	30,69%	18,47%	27,24%	21,11%	26,23%
Home or Draw			72,08%			70,33%	72,00%	71,79%	75,25%	69,32%	81,53%	72,76%	78,88%	73,77%
Draw or Away			50,53%			54,07%	51,11%	55,13%	50,50%	50,35%	55,40%	52,69%	53,07%	52,54%
HT 0.5 Scored			81,00%			78,00%	80,00%	71,00%	78,00%	77,00%	76,00%	77,00%	78,00%	77,33%
HT 1.5 Scored			46,00%			44,00%	45,00%	40,00%	46,00%	47,00%	39,00%	48,00%	38,00%	43,67%
HT 0.5 Conceded			67,00%			69,00%	77,00%	63,00%	61,00%	71,00%	61,00%	71,00%	60,00%	66,67%
HT 1.5 Conceded			32,00%			33,00%	31,00%	24,00%	27,00%	30,00%	20,00%	33,00%	23,00%	28,11%
AT 0.5 Scored			67,00%			69,00%	67,00%	63,00%	61,00%	70,00%	61,00%	71,00%	60,00%	65,44%
AT 1.5 Scored			32,00%			33,00%	31,00%	24,00%	27,00%	30,00%	20,00%	33,00%	23,00%	28,11%
AT 0.5 Conceded			81,00%			77,00%	80,00%	71,00%	78,00%	77,00%	76,00%	77,00%	78,00%	77,22%
AT 1.5 Conceded			46,00%			44,00%	45,00%	40,00%	44,00%	47,00%	39,00%	48,00%	38,00%	43,44%

	
- Resultado Final
	+ 1	- 47,46%
		>= 70 - VERY_LARGE
		>= 60 - LARGE
		>= 40 - MEDIUM
		>= 20 - LOW
	+ 2 - 26,23%
		>= 55 - VERY_LARGE
		>= 45 - LARGE
		>= 25 - MEDIUM
		>= 15 - LOW
- Hipotese Dupla
	+ 1X - 73,77%
		>= 90 - VERY_LARGE
		>= 80 - LARGE
		>= 70 - MEDIUM
		>= 60 - LOW
	+ X2 - 52,54%
		>= 80 - VERY_LARGE
		>= 70 - LARGE
		>= 50 - MEDIUM
		>= 20 - LOW
- Gols
	+ HT - Over 0.5 Scored - 77,33%
		>= 90 - VERY_LARGE
		>= 80 - LARGE
		>= 70 - MEDIUM
		>= 60 - LOW
	+ HT - Over 1.5 Scored - 43,67%
		>= 70 - VERY_LARGE
		>= 60 - LARGE
		>= 40 - MEDIUM
		>= 30 - LOW
	+ AT - Over 0.5 Scored - 65,44%
		>= 90 - VERY_LARGE
		>= 80 - LARGE
		>= 60 - MEDIUM
		>= 50 - LOW
	+ AT - Over 1.5 Scored - 28,11%
		>= 50 - VERY_LARGE
		>= 40 - LARGE
		>= 20 - MEDIUM
		>= 10 - LOW
		
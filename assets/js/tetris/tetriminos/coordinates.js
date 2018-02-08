var tetriminos = [
    //O
	{
        nom: 'O',
		couleur: '#FDD835',
		figures: [
			{
				blocs: [
					{ positionY: 0, positionX: 0 },
					{ positionY: 1, positionX: 0 },
					{ positionY: 0, positionX: 1 },
					{ positionY: 1, positionX: 1 }
				]
			}
		]
	},


    //I
	{
        nom: 'I',
		couleur: '#039BE5',
		figures: [
			{
				blocs: [
					{ positionY: 0, positionX: 0 },
					{ positionY: 1, positionX: 0 },
					{ positionY: 2, positionX: 0 },
					{ positionY: 3, positionX: 0 }
				]
			},
			{
				blocs: [
					{ positionY: 0, positionX: 0 },
					{ positionY: 0, positionX: 1 },
					{ positionY: 0, positionX: 2 },
					{ positionY: 0, positionX: 3 }
				]
			}
		]
	},


    //T
	{
        nom: 'T',
		couleur: '#D81B60',
		figures: [
			{
				blocs: [
					{ positionY: 0, positionX: 1 },
					{ positionY: 1, positionX: 0 },
					{ positionY: 1, positionX: 1 },
                    { positionY: 1, positionX: 2 }
				]
			},
			{
				blocs: [
					{ positionY: 0, positionX: 0 },
					{ positionY: 1, positionX: 0 },
					{ positionY: 2, positionX: 0 },
                    { positionY: 1, positionX: 1 }
				]
			},
			{
				blocs: [
					{ positionY: 0, positionX: 0 },
					{ positionY: 0, positionX: 1 },
					{ positionY: 0, positionX: 2 },
                    { positionY: 1, positionX: 1 }
				]
			},
			{
				blocs: [
					{ positionY: 0, positionX: 1 },
					{ positionY: 1, positionX: 1 },
					{ positionY: 2, positionX: 1 },
                    { positionY: 1, positionX: 0 }
				]
			}
		]
	}
];



//On converti les coordonnées en matrices
for (let tetrimino of tetriminos) {
	for (let figure of tetrimino.figures) {
		var myHauteur = 0;
		var myLargeur = 0;
		figure.matrice = [];

		//On cherche la hauteur et la largeur (plus grand Y et plus grand X)
		for (let bloc of figure.blocs) {
			if (myHauteur < bloc.positionY) {
				myHauteur = bloc.positionY;
			}

			if (myLargeur < bloc.positionX) {
				myLargeur = bloc.positionX;
			}
		};

		//On met +1 à la hauteur et à la largeur, parce que les index démarrent à 0
		myHauteur++;
		myLargeur++;

		//On converti la figure en matrice
		//On commence par initialiser une nouvelle matrice
		for (var y = 0; y < myHauteur; y++) {
			figure.matrice[y] = [];

			for (var x = 0; x < myLargeur; x++) {
				figure.matrice[y][x] = 0;
			}
		}

		//Pour chaque bloc, on met "1" dans la matrice
		for (let bloc of figure.blocs) {
			figure.matrice[bloc.positionY][bloc.positionX] = 1;
		};
	};
};

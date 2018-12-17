
public class CargaDatos{
	DNode lineaAzul[]=new DNode[11];
	DNode lineaVerde[]=new DNode[6];
	DNode lineaRoja[]=new DNode[12];
	DNode lineaPakhtakorAlisherNavoi[]=new DNode[2];
	DNode lineaMingUrikOybek[]=new DNode[2];
	DNode lineaAmirTemurHiyoboniYunusRajabiy[]=new DNode[2];
	CargaDatos(){
		/////ESTACIONES LINEA AZUL
		Punto Beruni=new Punto(41.346009, 69.206540);
		Punto Tinchlik=new Punto(41.332006, 69.219117);
		Punto Chorsu=new Punto(41.326303, 69.237846);
		Punto Gafur_Gulom=new Punto(41.327509, 69.247508);
		Punto Alisher_Navoi=new Punto(41.319945, 69.254060);
		Punto Uzbekistan=new Punto(41.311121, 69.253064);
		Punto Kosmonavtlar=new Punto(41.305183, 69.263883);
		Punto Oybek=new Punto(41.298385, 69.273071);
		Punto Toshkent=new Punto(41.292453, 69.286843);
		Punto Mashinasozlar=new Punto(41.299495, 69.304386);
		Punto Dostlik=new Punto(41.294262, 69.321609);
		
		//////ESTACIONES LINEA VERDE
		Punto Shakriston=new Punto(41.352897, 69.287874);
		Punto Bodomzor=new Punto(41.337708, 69.284742);
		Punto Minor=new Punto( 41.327392, 69.283498);
		Punto Abdulla_Kodiriy=new Punto(41.319247, 69.282034);
		Punto Yunus_Rajabiy=new Punto( 41.305185, 69.263881);
		Punto Ming_Urik=new Punto(41.298311, 69.286149);
		
		////////ESTACIONES LINEA ROJA
		Punto Olmazor=new Punto(41.257396, 69.195919);
		Punto Chilonzor=new Punto(41.273892, 69.203777);
		Punto Mirzo_Ulugbek=new Punto(41.282858, 69.212557);
		Punto Novza=new Punto(41.291297, 69.223256);
		Punto Milliy_Bog=new Punto( 41.304454, 69.234952);
		Punto Bunyodkor=new Punto( 41.311413, 69.241950);
		Punto Pakhtakor=new Punto(41.317643, 69.256098);
		Punto Mustakillik_Maydoni=new Punto(41.315348, 69.270569); 
		Punto Amir_Temur_Hiyoboni=new Punto(41.313287, 69.284322);
		Punto Khamid_Alimjan=new Punto(41.317384, 69.294859);
		Punto Pushkin=new Punto(41.322252, 69.312229);
		Punto Buyuk_Ipak_Yuli=new Punto(41.326188, 69.327542);
		
		//lineaAzul
		lineaAzul[0]=new DNode(null,null,"Beruni",null,null,Beruni,1.48);
		lineaAzul[1]=new DNode (lineaAzul[0],null,"Tinchlik",null,null,Tinchlik,1.4);
		lineaAzul[2]=new DNode(lineaAzul[1],null,"Chorsu",null,null,Chorsu,1.49);
		lineaAzul[3]=new DNode(lineaAzul[2],null,"Gafur Gulom",null,null,Gafur_Gulom,1.48);
		lineaAzul[4]=new DNode(lineaAzul[3],null,"Alisher Navoi(Linea Azul)",null,null,Alisher_Navoi,1.65);
		lineaAzul[5]=new DNode(lineaAzul[4],null,"Uzbekistan",null,null,Uzbekistan,1.62);
		lineaAzul[6]=new DNode(lineaAzul[5],null,"Kosmonavtlar",null,null,Kosmonavtlar,1.56);
		lineaAzul[7]=new DNode(lineaAzul[6],null,"Oybek(Linea Azul)",null,null,Oybek,1.63);
		lineaAzul[8]=new DNode(lineaAzul[7],null,"Toshkent",null,null,Toshkent,1.22);
		lineaAzul[9]=new DNode(lineaAzul[8],null,"Mashinasozlar",null,null,Mashinasozlar,1.06);
		lineaAzul[10]=new DNode(lineaAzul[9],null,"Dostlik",null,null,Dostlik,1.44);
		
		for (int i=0;i<lineaAzul.length;i++){ //Bucle para rellenar los siguientes en linea1
			if(i!=lineaAzul.length-1)
				lineaAzul[i].setNext(lineaAzul[i+1]);
		}
		/////////////////////////////////////////lineaVerde///////////////////////////////////////////////////////////////////
		lineaVerde[0]=new DNode(null,null,"Shakriston",null,null,Shakriston,0.985);
		lineaVerde[1]=new DNode(lineaVerde[0],null,"Bodomzor",null,null,Bodomzor,1.36);
		lineaVerde[2]=new DNode(lineaVerde[1],null,"Minor",null,null,Minor,1.8);
		lineaVerde[3]=new DNode(lineaVerde[2],null,"Abdulla Kodiriy",null,null,Abdulla_Kodiriy,1.26);
		lineaVerde[4]=new DNode(lineaVerde[3],null,"Yunus Rajabiy(linea Verde)",null,null,Yunus_Rajabiy,1.2);
		lineaVerde[5]=new DNode(lineaVerde[4],null,"Ming Urik(Linea Verde)",null,null,Ming_Urik,1.47);
		
		for (int c=0;c<lineaVerde.length;c++){ //Bucle para rellenar los siguientes en linea2
			if(c!=lineaVerde.length-1)
				lineaVerde[c].setNext(lineaVerde[c+1]);
		}
		/////////////////////////////////////////lineaRoja///////////////////////////////////////////////////////////////////

		lineaRoja[0]=new DNode(null,null,"Olmazor",null,null,Olmazor,1.26);
		lineaRoja[1]=new DNode (lineaRoja[0],null,"Chilonzor",null,null,Chilonzor,1.38);
		lineaRoja[2]=new DNode(lineaRoja[1],null,"Mirzo Ulugbek",null,null,Mirzo_Ulugbek,0.949);
		lineaRoja[3]=new DNode(lineaRoja[2],null,"Novza",null,null,Novza,1.81);
		lineaRoja[4]=new DNode(lineaRoja[3],null,"Milliy Bog",null,null,Milliy_Bog,1.66);
		lineaRoja[5]=new DNode(lineaRoja[4],null,"Bunyodkor",null,null,Bunyodkor,1.06);
		lineaRoja[6]=new DNode(lineaRoja[5],null,"Pakhtakor(Linea Roja)",null,null,Pakhtakor,1.22);
		lineaRoja[7]=new DNode(lineaRoja[6],null,"Mustakillik Maydoni",null,null,Mustakillik_Maydoni,1.63);
		lineaRoja[8]=new DNode(lineaRoja[7],null,"Amir Temur Hiyoboni(Linea Roja)",null,null,Amir_Temur_Hiyoboni,1.56);
		lineaRoja[9]=new DNode(lineaRoja[8],null,"Khamid Alimjan",null,null,Khamid_Alimjan,1.62);
		lineaRoja[10]=new DNode(lineaRoja[9],null,"Pushkin",null,null,Pushkin,1.65);
		lineaRoja[11]=new DNode(lineaRoja[10],null,"Buyuk Ipak Yuli",null,null,Buyuk_Ipak_Yuli,1.16);
		
		for (int i=0;i<lineaRoja.length;i++){ //Bucle para rellenar los siguientes en linea3
			if(i!=lineaRoja.length-1)
				lineaRoja[i].setNext(lineaRoja[i+1]);
		}
		///////////////////////////////////////////////LineaPakhtakor/AlisherNavoi////////////////////////////////////////
		
		lineaPakhtakorAlisherNavoi[0]=new DNode(null,null,"Pakhtakor(Trasbordo a pie)",null,null,Pakhtakor,36.12);
		lineaPakhtakorAlisherNavoi[1]=new DNode (lineaPakhtakorAlisherNavoi[0],null,"Alisher Navoi(Trasbordo a pie)",null,null,Alisher_Navoi,36.12);
		lineaPakhtakorAlisherNavoi[0].setNext(lineaPakhtakorAlisherNavoi[1]);
		//////////////////////////////////////LineaMingUrik/Oybek////////////////////////////////////////
		lineaMingUrikOybek[0]=new DNode(null,null,"Ming Urik(Trasbordo a pie)",null,null,Ming_Urik,3.595);
		lineaMingUrikOybek[1]=new DNode(lineaMingUrikOybek[0],null,"Oybek(Trasbordo a pie)",null,null,Oybek,3.595);
		lineaMingUrikOybek[0].setNext(lineaMingUrikOybek[1]);
		///////////////////////////////////////lineaAmirTemurHiyoboniYunusRajabiy/////////////////////
		lineaAmirTemurHiyoboniYunusRajabiy[0]=new DNode(null,null,"Amir Temur Hiyoboni(Trasbordo a pie )",null,null,Amir_Temur_Hiyoboni,16.00);
		lineaAmirTemurHiyoboniYunusRajabiy[1]=new DNode (lineaAmirTemurHiyoboniYunusRajabiy[0],null,"Yunus Rajabiy(Trasbordo a pie)",null,null,Yunus_Rajabiy,16.00);
		lineaAmirTemurHiyoboniYunusRajabiy[0].setNext(lineaAmirTemurHiyoboniYunusRajabiy[1]);
		
		
		//rellenamos los transbordos de todas las lineas
		lineaAzul[4].transbordo1=lineaPakhtakorAlisherNavoi[1];
		lineaAzul[7].transbordo1=lineaMingUrikOybek[1];
		lineaVerde[4].transbordo1=lineaAmirTemurHiyoboniYunusRajabiy[1];
		lineaVerde[5].transbordo1=lineaMingUrikOybek[0];
		lineaRoja[6].transbordo1=lineaPakhtakorAlisherNavoi[0];
		lineaRoja[8].transbordo1=lineaAmirTemurHiyoboniYunusRajabiy[0];
		lineaPakhtakorAlisherNavoi[0].transbordo1=lineaRoja[6];
		lineaPakhtakorAlisherNavoi[1].transbordo1=lineaAzul[4];
		lineaAmirTemurHiyoboniYunusRajabiy[0].transbordo1=lineaRoja[8];
		lineaAmirTemurHiyoboniYunusRajabiy[1].transbordo1=lineaVerde[4];
		lineaMingUrikOybek[0].transbordo1=lineaVerde[5];
		lineaMingUrikOybek[1].transbordo1=lineaAzul[7];
		
		
	}
}
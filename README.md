# GestionJoe-BackEnd


localhost:8080/Employes method= GET :List all employes

localhost:8080/Employes/{cin} method=GET :Chercher par Cin

localhost:8080/Employes method=post :inserer un employe

localhost:8080/Employes/{cin} method=PUT :Modifi un employe

localhost:8080/Employes/{cin} method=Delete :supprime un employe

localhost:8080/Employe/auth method=post :requete d'authentification qui return si il existe ou pas avec les ces attributs si il existe
*******************************************
localhost:8080/Dossiers method= GET :List all dossiers

localhost:8080/Dossiers/{id} method=GET :Chercher par id

localhost:8080/Dossiers method=post :inserer un dossier

localhost:8080/Dossiers/{code} method=PUT :Modifi un dossier

localhost:8080/Dossiers/{d} method=Delete :supprime un dossier
***************************************
localhost:8080/Contrats method= GET :List all contrats

localhost:8080/Contrats/{c} method=GET :Chercher par id

localhost:8080/Contrats method=post :inserer un contrat

localhost:8080/Contrats/{code} method=PUT :Modifi un contrat

localhost:8080/Contrats/{c} method=Delete :supprime un contrat
****************************
localhost:8080/CongesEnAttente method= GET :List all demande/conge en attente

localhost:8080/CongesEnAttenteParEmploye/{cin} : List all demande/conge en attente par employe

localhost:8080/CongesRefuser : List all demande/conge refusee

localhost:8080/CongesRefuserParEmploye/{cin}  : List all demande/conge refusee par employe

localhost:8080/CongesAccepter: List all demande/conge acceptee

localhost:8080/CongesAccepterParEmploye/{cin}  : List all demande/conge acceptee par employe

localhost:8080/Conges/{code} :update demande/conge 

localhost:8080/CongesAccepter/{code} :accepter conge/demande

localhost:8080/CongesRefuser/{code}: refuser conge/demande

localhost:8080/Conges   : ajouter conge/demande

localhost:8080/Conges/{c}  supprimer conge/demande











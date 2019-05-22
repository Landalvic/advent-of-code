const getConfiguration = propriete =>
  fetch("/jeux_entre_amis/configuration.json")
    .then(response => response.json())
    .then(json => json[propriete])
    .catch(e => console.log(e));

export default getConfiguration;

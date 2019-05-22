import axios from "axios";
import getConfiguration from "utils/configuration";

export default async function API() {
  const nomServeur = await getConfiguration("api");

  const myAxios = axios.create({
    baseURL: `${nomServeur}`
  });

  myAxios.interceptors.request.use(config => {
    config.withCredentials = true;
    config.headers["Content-Type"] = "application/json;charset=utf-8";
    config.headers.Accept = "application/json;charset=utf-8";
    return Promise.resolve(config);
  });

  return myAxios;
}

import axios from 'axios';

export function getAllShelters() {
  return axios.get('/shelter');
}

export function getShelterInfo(stateCode) {
  return axios.get(`/shelter/state?stateCode=${stateCode}`);
}

export function getShelterById(id) {
  return axios.get(`/shelter/${id}`);
}

export function createShelter(shelter) {
  return axios.post('/shelter', shelter);
}

export function updateShelter(id, shelter) {
  return axios.put(`/shelter/${id}`, shelter);
}

export function deleteShelter(id) {
  return axios.delete(`/shelter/${id}`);
}

const ShelterService = {
  getAllShelters,
  getShelterInfo,
  getShelterById,
  createShelter,
  updateShelter,
  deleteShelter
};

export default ShelterService;
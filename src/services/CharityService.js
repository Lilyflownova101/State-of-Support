import axios from 'axios';

export function getAllCharities() {
  return axios.get('/charity');
}

export function getCharityInfo(stateCode) {
  return axios.get(`/charity/state?stateCode=${stateCode}`);
}

export function getCharityById(id) {
  return axios.get(`/charity/${id}`);
}

export function createCharity(charity) {
  return axios.post('/charity', charity);
}

export function updateCharity(id, charity) {
  return axios.put(`/charity/${id}`, charity);
}

export function deleteCharity(id) {
  return axios.delete(`/charity/${id}`);
}

const CharityService = {
  getAllCharities,
  getCharityInfo,
  getCharityById,
  createCharity,
  updateCharity,
  deleteCharity
};

export default CharityService;
import axios from 'axios';

export function getStateInfo(stateCode) {
  return axios.get(`/state/${stateCode}`);
}

export function getAllStates() {
  return axios.get('/state');
}

export function createState(state) {
  return axios.post('/state', state);
}

export function updateState(stateCode, state) {
  return axios.put(`/state/${stateCode}`, state);
}

export function deleteState(stateCode) {
  return axios.delete(`/state/${stateCode}`);
}

const StateService = {
  getStateInfo,
  getAllStates,
  createState,
  updateState,
  deleteState
};

export default StateService;
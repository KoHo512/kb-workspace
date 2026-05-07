import axios from 'axios'

const BASE_URL = '/api/diary'

export const getDiaries = async () => {
  const response = await axios.get(BASE_URL)
  return response.data
}

export const getDiaryById = async (id) => {
  const response = await axios.get(`${BASE_URL}/${id}`)
  return response.data
}

export const createDiary = async (diary) => {
  const response = await axios.post(BASE_URL, diary)
  return response.data
}

export const updateDiary = async (id, diary) => {
  const response = await axios.put(`${BASE_URL}/${id}`, diary)
  return response.data
}

export const deleteDiary = async (id) => {
  const response = await axios.delete(`${BASE_URL}/${id}`)
  return response.data
}

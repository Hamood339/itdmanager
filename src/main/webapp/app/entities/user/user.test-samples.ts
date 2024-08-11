import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 6927,
  login: 'X$OwaU@SWPX\\v5v3oN3\\@D',
};

export const sampleWithPartialData: IUser = {
  id: 6042,
  login: 'A6J',
};

export const sampleWithFullData: IUser = {
  id: 23899,
  login: 'WOe2rW',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

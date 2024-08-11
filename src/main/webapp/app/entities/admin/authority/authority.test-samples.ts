import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '9eb7e49c-9c69-4077-ad15-fe11c5fb739f',
};

export const sampleWithPartialData: IAuthority = {
  name: '98c702d3-815f-4478-8cbc-996c0e99bea1',
};

export const sampleWithFullData: IAuthority = {
  name: '5f6e9b26-faf9-4ff6-acbf-6afaa5478901',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);

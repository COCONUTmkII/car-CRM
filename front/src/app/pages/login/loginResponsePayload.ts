export interface LoginResponsePayload {
  authenticationToken: string;
  refreshToken: string;
  expiresAt: Date;
  nickname: string;
}

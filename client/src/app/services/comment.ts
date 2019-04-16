import { UserExample } from "./user";

export class CommentExample{
    id: number;
    body: string;
    createDate: string;
    user: UserExample;
    constructor(){}
}
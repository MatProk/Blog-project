import { UserExample } from "./user";
import { CommentExample } from "./comment";

export class PostExample{
    id: number;
    title: string;
    content: string;
    createDate: string;
    user: UserExample;
    comments: CommentExample;
    constructor(){}
}
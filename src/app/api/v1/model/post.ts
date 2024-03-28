/**
 * Title: Skeleton Open Api.
 * Description: This is the Skeleton Open Api definition.
 *
 * The version of the OpenAPI document: 0.1.9
 */
export interface Post { 
    /**
     * record id
     */
    id: number;
    /**
     * unique user identifier
     */
    userId: string;
    /**
     * title of this Post
     */
    title: string;
    /**
     * description of this post
     */
    body: string;
}


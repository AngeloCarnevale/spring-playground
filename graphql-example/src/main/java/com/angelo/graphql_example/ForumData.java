
package com.angelo.graphql_example;
record Post(String id, String content) {

}

record Comment(String id, String content, String postId) {
}
#version 430 core

uniform mat4 mvpMatrix;

layout(location=0) in vec4 vVertex;
layout(location=1) in vec2 vTexCoord0;

out vec2 vTex;

void main(void) 
{
	vTex = vTexCoord0; 
	gl_Position = mvpMatrix * vVertex; 
}

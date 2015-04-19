#version 430 core

uniform mat4 mvpMatrix;

layout(location=0) in vec4 vColor;
layout(location=1) in vec4 vVertex;

out vec4 vFragColor;

void main(void)
{
	vFragColor = vColor; 
 	gl_Position = mvpMatrix * vVertex; 
}

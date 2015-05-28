#version 430 core

uniform vec4 vColor;
out vec4 color;

void main(void)
{
	color = vColor;
}
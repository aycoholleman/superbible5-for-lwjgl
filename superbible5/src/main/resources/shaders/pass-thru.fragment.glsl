#version 430 core

layout(location=0) in vec4 passColor;

out vec4 outColor;

void main(void)
{
	outColor = passColor;
}
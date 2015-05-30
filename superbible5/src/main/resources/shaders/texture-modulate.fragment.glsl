#version 430 core

in vec2 vTex;

uniform sampler2D textureUnit0;
uniform vec4 vColor;

out vec4 color;

void main(void)
{
	color = vColor * texture2D(textureUnit0, vTex);
}
